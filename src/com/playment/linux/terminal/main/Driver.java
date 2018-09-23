package com.playment.linux.terminal.main;

import java.util.Scanner;

import com.playment.linux.terminal.commands.CommandFactory;

public class Driver {

	private static Scanner in;

	private static String cursor = "$";

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		while (true) {
			System.out.print(cursor + " ");
			String command = in.next();
			if (command.equals("quit"))
				break;
			String nextLine = in.nextLine().trim();
			String[] commandArgs;
			if (nextLine.equals(""))
				commandArgs = new String[0];
			else
				commandArgs = nextLine.split(" +");

			CommandFactory.executeCommand(command, commandArgs);
			System.out.println();
		}
		in.close();
	}

}
