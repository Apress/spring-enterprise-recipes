#!/usr/bin/env ruby 
require 'find'
require 'fileutils'

ignorable = []
bad_regs = [  /target$/, /\.settings$/, /\.project/ ,/\.classpath/, /.*?\.iws/ ,/.*?\.iml/,/.*?\.ipr/]

Find.find( '..') do |file|
  bad_regs.each do |reg|
   ignorable.push(file) if ( file =~ reg) != nil 
   end
end 

  
ignorable.each do| file_name | 
  
  puts '-' * 100
  puts file_name 
  dir = File.dirname( file_name)
  fn = File.basename( file_name)
   
   
  
  cmd = %| svn propset svn:ignore #{fn} #{dir} |
  puts cmd
  
  
  
end