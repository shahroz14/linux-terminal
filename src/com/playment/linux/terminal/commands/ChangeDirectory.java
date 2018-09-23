package com.playment.linux.terminal.commands;

public class ChangeDirectory implements Command {

	@Override
	public void execute(String... args) {
		if (args.length > 0) {
			fileStructure.changeDirectory(args[0]);
		} else {
			System.out.println("The syntax of the command is incorrect.");
		}
	}

}
