package com.playment.linux.terminal.commands;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.playment.linux.terminal.utils.CommandUtils;

/**
 * All implementation of commands resides here. All are loaded eagerly in a map.
 * All classes in this package implementing Command interface is considered as
 * Command implementation.
 * 
 * @author Shahroz Saleem
 *
 */
public class CommandFactory {

	private static Map<String, Command> commands = new HashMap<>();

	static {
		Iterator<Class<? extends Command>> iterator = CommandUtils.getAllCommandsImplementations().iterator();
		while (iterator.hasNext()) {
			Class<? extends Command> command = iterator.next();
			Command commandInstance = CommandUtils.getCommandInstance(command);
			commands.put(commandInstance.getCommandString(), commandInstance);
		}
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
			System.out.println("ERR: CANNOT RECOGNIZE INPUT.");
		} else {
			commands.get(command).execute(args);
		}
	}

}
