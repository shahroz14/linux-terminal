package com.playment.linux.terminal.commands;

public class MakeDirectory implements Command {

	@Override
	public void execute(String... args) {
		if (args.length > 0) {
			fileStructure.makeDirectories(args);
		} else {
			System.out.println("The syntax of the command is incorrect.");
		}
	}

}
