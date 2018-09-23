package com.playment.linux.terminal.commands;

public class ListDirectories implements Command {
	
	private static ListDirectories listDirectories;

	private ListDirectories() {
		
	}

	public static ListDirectories getInstance() {
		if (listDirectories == null)
			listDirectories = new ListDirectories();
		return listDirectories;
	}

	@Override
	public void execute(String... args) {
		fileStructure.listDirectories();
	}

	@Override
	public String getCommandString() {
		return "ls";
	}

}
