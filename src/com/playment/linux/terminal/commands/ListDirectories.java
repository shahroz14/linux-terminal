package com.playment.linux.terminal.commands;

public class ListDirectories implements Command {

	@Override
	public void execute(String... args) {
		fileStructure.listDirectories();
	}

}
