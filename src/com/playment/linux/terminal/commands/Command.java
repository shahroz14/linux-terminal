package com.playment.linux.terminal.commands;

import com.playment.linux.terminal.files.FileStructure;

public interface Command {
	
	public static FileStructure fileStructure = new FileStructure();
	
	public void execute(String... args);
	
	public String getCommandString();

}
