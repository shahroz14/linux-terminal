package com.playment.linux.terminal.commands;

/**
 * This will list the present working directory.
 * 
 * <p>
 * Present working directory will be an absolute path (i.e from the root).
 * </p>
 * 
 * <p>
 * Command is: <b>pwd</b>
 * </p>
 * 
 * @author Shahroz Saleem
 *
 */
public class PresentWorkingDirectory implements Command {

	private static PresentWorkingDirectory presentWorkingDirectory;

	private PresentWorkingDirectory() {

	}

	public static PresentWorkingDirectory getInstance() {
		if (presentWorkingDirectory == null)
			presentWorkingDirectory = new PresentWorkingDirectory();
		return presentWorkingDirectory;
	}

	@Override
	public void execute(String... args) {
		if (args.length == 0)
			fileStructure.getCurrentDirectoryPath();
		else
			System.out.println("Illegal arguments");
	}

	@Override
	public String getCommandString() {
		return "pwd";
	}

}
