package com.playment.linux.terminal.commands;

public class RemoveDirectory implements Command {

	@Override
	public void execute(String... args) {
		fileStructure.removeDirectories(args);
	}

}
