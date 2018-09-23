package com.playment.linux.terminal.commands;

public class MakeDirectory implements Command {
	
	private static MakeDirectory makeDirectory;
	
	private MakeDirectory() {
		
	}
	
	public static MakeDirectory getInstance() {
		if(makeDirectory == null)
			makeDirectory = new MakeDirectory();
		return makeDirectory;
	}

	@Override
	public void execute(String... args) {
		if (args.length > 0) {
			fileStructure.makeDirectories(args);
		} else {
			System.out.println("The syntax of the command is incorrect.");
		}
	}

	@Override
	public String getCommandString() {
		return "mkdir";
	}

}
