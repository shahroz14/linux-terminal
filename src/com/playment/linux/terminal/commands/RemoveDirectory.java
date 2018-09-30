package com.playment.linux.terminal.commands;

/**
 * This will remove the directory from the specified path.
 * 
 * <p>
 * Command is: <b>rm</b>
 * </p>
 * 
 * @author Shahroz Saleem
 *
 */
public class RemoveDirectory implements Command {

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
		if (args.length > 0)
			fileStructure.removeDirectories(args);
		else
			System.out.println("The syntax of the command is incorrect.");
	}

	@Override
	public String getCommandString() {
		return "rm";
	}

}
