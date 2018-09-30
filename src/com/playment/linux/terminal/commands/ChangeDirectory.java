package com.playment.linux.terminal.commands;

/**
 * <p>
 * <b>Change Directory </b> is used to change the present working directory.
 * After doing this all paths passed to the following commands will be relative
 * from this path.
 * </p>
 * 
 * <p>
 * Command is: <b> cd </b>
 * </p>
 * 
 * @author shahroz
 *
 */
public class ChangeDirectory implements Command {

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
		if (args.length == 1) {
			fileStructure.changeDirectory(args[0]);
		} else {
			System.out.println("Illegal arguments.");
		}
	}

	@Override
	public String getCommandString() {
		return "cd";
	}

}
