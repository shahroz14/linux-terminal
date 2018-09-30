package com.playment.linux.terminal.commands;

import com.playment.linux.terminal.files.FileStructure;

/**
 * All commands should implement this interface.
 * 
 * @author Shahroz Saleeem
 *
 */
public interface Command {

	/**
	 * This object denotes the entire file system. All related method to manipulate
	 * folder and its structure goes inside this.
	 */
	public static FileStructure fileStructure = new FileStructure();

	/**
	 * All implementation classes will provide the implementation of this method.
	 * This method gets triggered as soon as the command string with arguments is
	 * typed in the console and hit enter. This is called by {@link CommandFactory}
	 * 
	 * @param args
	 *            This are the parameters required by the command. In case no
	 *            parameter is required, can be given as null.
	 * 
	 */
	public void execute(String... args);

	/**
	 * This denotes the string with which command will be fired.
	 * 
	 * @return
	 */
	public String getCommandString();

}
