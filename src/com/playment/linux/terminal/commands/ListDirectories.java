package com.playment.linux.terminal.commands;

/**
 * This command is for listing all directories in the present working directory.
 * This will list all the keys (i.e directory names) corresponding to present
 * working directory.
 * 
 * @author Shahroz Saleem
 *
 */
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
		if (args.length > 0)
			System.out.println("Illegal arguments");
		else
			fileStructure.listDirectories();
	}

	@Override
	public String getCommandString() {
		return "ls";
	}

}
