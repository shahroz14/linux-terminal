package com.playment.linux.terminal.commands;

/**
 * 
 * <b> Clear Session </b> is used to clear all directories from the root. Also
 * present working directory will be changed to root.
 * 
 * <p>
 * Command is : <b> clear </b>
 * </p>
 * 
 * @author Shahroz Saleem
 *
 */
public class Session implements Command {

	private static Session session;

	private Session() {

	}

	public static Session getInstance() {
		if (session == null)
			session = new Session();
		return session;
	}

	@Override
	public void execute(String... args) {
		if (args.length > 0) {
			if (args[0].equals("clear"))
				fileStructure.clearSession();
			else
				System.out.println("No command found");
		} else
			System.out.println("The syntax of the command is incorrect.");
	}

	@Override
	public String getCommandString() {
		return "session";
	}

}
