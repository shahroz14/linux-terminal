package com.playment.linux.terminal.commands;

public class ClearSession implements Command {

	@Override
	public void execute(String... args) {
		fileStructure.clearSession();
	}

}
