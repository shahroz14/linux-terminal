package com.playment.linux.terminal.commands;

public class ChangeDirectory implements Command {

	private String commandString;
	
	private static ChangeDirectory changeDirectory;

	private ChangeDirectory() {
		
	}

	public static ChangeDirectory getInstance() {
		if (changeDirectory == null)
			changeDirectory = new ChangeDirectory();
		return changeDirectory;
	}

	@Override
	public void execute(String... args) {
		if (args.length > 0) {
			fileStructure.changeDirectory(args[0]);
		} else {
			System.out.println("The syntax of the command is incorrect.");
		}
	}

	@Override
	public String getCommandString() {
		return commandString;
	}

}
