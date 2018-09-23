package com.playment.linux.terminal.commands;

public class PresentWorkingDirectory implements Command {
	
	private static PresentWorkingDirectory presentWorkingDirectory;
	
	private PresentWorkingDirectory() {
		
	}
	
	public static PresentWorkingDirectory getInstance() {
		if(presentWorkingDirectory == null)
			presentWorkingDirectory = new PresentWorkingDirectory();
		return presentWorkingDirectory;
	}

	@Override
	public void execute(String... args) {
		fileStructure.getCurrentDirectoryPath();
	}

	@Override
	public String getCommandString() {
		return "pwd";
	}

}
