package com.playment.linux.terminal.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.reflections.Reflections;

import com.playment.linux.terminal.commands.Command;

public class CommandUtils {

	private static final String COMMAND_BASE_PACKAGE = "com.playment.linux.terminal.commands";

	public static Set<Class<? extends Command>> getAllCommandsImplementations() {
		Reflections reflections = new Reflections(COMMAND_BASE_PACKAGE);
		return reflections.getSubTypesOf(Command.class);
	}

	public static Command getCommandInstance(Class<? extends Command> command) {
		Command commandInstance = null;
		try {
			commandInstance = (Command) command.getDeclaredMethod("getInstance").invoke(command);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			System.out.println(
					"Error creating instance of the given class. Please note that the given class should implement Command interface.");
		}
		return commandInstance;
	}
	
}
