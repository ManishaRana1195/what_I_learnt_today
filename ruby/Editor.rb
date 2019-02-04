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
        handle_input
      end
    end
  end

  def handle_input
    input = $stdin.getc
    case input
    when "\C-q" then
      exit(0)
    end
  end

end


Editor.new.execute
