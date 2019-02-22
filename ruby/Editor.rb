#!/usr/bin/env ruby

require "io/console"

class Editor

  def initialize
    lines = File.readlines("sample.txt").map do |line|
      line.sub(/\n$/, "")
    end
  end

  def execute
    IO.console.raw do
      loop do
        render_screen
        handle_input
      end
    end
  end

  def render_screen
    CSI.clear_screen
    CSI.move_cursor(0,0)
  end

  def handle_input
    input = $stdin.getc
    case input
    when "\C-q" then
      exit(0)
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

Editor.new.execute
