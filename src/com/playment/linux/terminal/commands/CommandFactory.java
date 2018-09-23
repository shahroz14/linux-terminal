package com.playment.linux.terminal.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * All implementation of commands resides here.
 * 
 * @author Shahroz Saleem
 *
 */
public class CommandFactory {

	private static Map<String, Command> commands = new HashMap<>();

	static {
		commands.put("mkdir", new MakeDirectory());
		commands.put("ls", new ListDirectories());
		commands.put("rm", new RemoveDirectory());
		commands.put("cd", new ChangeDirectory());
		commands.put("pwd", new PresentWorkingDirectory());
		commands.put("clear", new ClearSession());
	}

	private static boolean isValidCommand(String command) {
		return commands.keySet().stream().anyMatch(s -> s.equals(command));
	}

	/**
	 * Checks if the given command is valid and execute the same.
	 * 
	 * @param command
	 *            This represents the unique command string used.
	 * @param args
	 *            All arguments that need for command execution. If no parameters
	 *            are needed, can be given as null.
	 */
	public static void executeCommand(String command, String... args) {
		if (!isValidCommand(command)) {
			System.out.println("Invalid command " + command);
		} else {
			commands.get(command).execute(args);
		}
	}

}
