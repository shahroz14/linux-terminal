package com.playment.linux.terminal.commands;

public class RemoveDirectory implements Command {

	private String commandString;

	private static RemoveDirectory removeDirectory;

	private RemoveDirectory() {
		
	}

	public static RemoveDirectory getInstance() {
		if (removeDirectory == null)
			removeDirectory = new RemoveDirectory();
		return removeDirectory;
	}

	@Override
	public void execute(String... args) {
		fileStructure.removeDirectories(args);
	}

	@Override
	public String getCommandString() {
		return commandString;
	}

}
