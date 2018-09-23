package com.playment.linux.terminal.commands;

public class ClearSession implements Command {
	
	private String commandString;
	
	private static ClearSession clearSession;

	private ClearSession() {
		
	}

	public static ClearSession getInstance() {
		if (clearSession == null)
			clearSession = new ClearSession();
		return clearSession;
	}

	@Override
	public void execute(String... args) {
		fileStructure.clearSession();
	}

	@Override
	public String getCommandString() {
		return commandString;
	}

}
