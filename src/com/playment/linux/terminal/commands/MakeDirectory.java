package com.playment.linux.terminal.commands;

/**
 * <p>
 * This command is used to make directories in the present working directory.
 * This will make directory according to the path given. Path starting from '/'
 * is considered as Absolute Path and directories will be created from root
 * folder. All directories before the directory name should already exist.
 * </p>
 * 
 * <p>
 * Path not starting from '/' is considered as Relative and will create
 * directories form the present working directory location.
 * </p>
 * 
 * @author Shahroz Saleem
 *
 */
public class MakeDirectory implements Command {

	private static MakeDirectory makeDirectory;

	private MakeDirectory() {

	}

	public static MakeDirectory getInstance() {
		if (makeDirectory == null)
			makeDirectory = new MakeDirectory();
		return makeDirectory;
	}

	@Override
	public void execute(String... args) {
		if (args.length > 0)
			fileStructure.makeDirectories(args);
		else
			System.out.println("The syntax of the command is incorrect.");

	}

	@Override
	public String getCommandString() {
		return "mkdir";
	}

}
