package com.playment.linux.terminal.commands;

public class PresentWorkingDirectory implements Command {

	@Override
	public void execute(String... args) {
		fileStructure.getCurrentDirectoryPath();
	}

}
