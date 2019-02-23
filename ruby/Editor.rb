#!/usr/bin/env ruby

require "io/console"

class Editor

  def initialize
    lines = File.readlines("sample.txt").map do |line|
      line.sub(/\n$/, "")
    end
    @buffer = Buffer.new(lines)
    @cursor = Cursor.new
  end

  def execute
    IO.console.raw do
      loop do
        render_screen
        handle_input
      end
    end
  rescue
    # give some space and then print the error
    50.times {puts}
    raise
  end

  def render_screen
    CSI.clear_screen
    CSI.move_cursor(0, 0)
    @buffer.render
    CSI.move_cursor(@cursor.row, @cursor.column)
  end

  def handle_input
    input = $stdin.getc
    case input
    when "\C-q" then exit(0)
    when "\C-n" then @cursor = @cursor.down(@buffer)
    when "\C-p" then @cursor = @cursor.up(@buffer)
    when "\C-b" then @cursor = @cursor.left(@buffer)
    when "\C-f" then @cursor = @cursor.right(@buffer)
    when 127.chr then
      if @cursor.column > 0
        @buffer = @buffer.delete(@cursor.row, @cursor.column)
        @cursor = @cursor.left(@buffer)
      end
    else
      @buffer = @buffer.insert(input, @cursor.row, @cursor.column)
      @cursor = @cursor.right(@buffer)
    end
  end

end

class CSI
  def self.clear_screen
    $stdout.write("\e[2J")
  end

  def self.move_cursor(row, column)
    $stdout.write("\e[#{row + 1};#{column + 1}H")
  end
end

class Buffer
  def initialize(lines)
    @lines = lines
  end

  def render
    @lines.each do |line|
      $stdout.write(line + "\r\n")
    end
  end

  def line_count
    @lines.count
  end

  def line_length(line)
    @lines.fetch(line).length
  end

  def insert(char, row, column)
    lines = @lines.map(&:dup)
    lines.fetch(row).insert(column, char)
    Buffer.new(lines)
  end

  def delete(row,column)
    lines = @lines.map(&:dup)
    lines.fetch(row).slice!(column)
    Buffer.new(lines)
  end
end

class Cursor
  attr_accessor :row, :column

  def initialize(row = 0, column = 0)
    @row = row
    @column = column
  end

  def down(buffer)
    Cursor.new(@row + 1, @column).restrict(buffer)
  end

  def up(buffer)
    Cursor.new(@row - 1, @column).restrict(buffer)
  end

  def left(buffer)
    Cursor.new(@row, @column - 1).restrict(buffer)
  end

  def right(buffer)
    Cursor.new(@row, @column + 1).restrict(buffer)
  end

  def restrict(buffer)
    row = @row.clamp(0, buffer.line_count + 1)
    column = @column.clamp(0, buffer.line_length(row))
    Cursor.new(row, column)
  end

end


Editor.new.execute
