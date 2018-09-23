package com.playment.linux.terminal.files;

import java.util.Map;
import java.util.TreeMap;

/**
 * This represent the Directory with reference to its parent directory and the
 * child all directories that it can hold.
 * 
 * @author Shahroz Saleem
 *
 */
public class FileNode {

	/*
	 * ===========================================================================
	 * Fields
	 * ===========================================================================
	 */

	/**
	 * Represent the directory name
	 */
	private String name;

	/**
	 * This will hold all the child directories inside the directory. Underlying
	 * data structure used is TreeMap so that directories name are kept in sorted
	 * order.
	 */
	private Map<String, FileNode> children;

	/**
	 * Represent the parent Directory. Helps in moving up in the directories
	 * hierarchy.
	 */
	private FileNode parent;

	/*
	 * ===========================================================================
	 * Constructors
	 * ===========================================================================
	 */

	public FileNode(String name) {
		this.name = name;
		children = new TreeMap<>();
	}

	/*
	 * ===========================================================================
	 * Methods
	 * ===========================================================================
	 */

	/**
	 * 
	 * @return name of the directory
	 */
	public String getName() {
		return name;
	}

	public void addDirectory(String name) {
		if (children.containsKey(name)) {
			System.out.println("Error: Directory '" + name + "' already exist");
		}
		FileNode node = new FileNode(name);
		node.parent = this;
		children.put(name, node);
	}

	public void removeDirectory(String name) {
		if (children.containsKey(name)) {
			children.remove(name);
		} else {
			System.out.println("Error: Directory '" + name + "' does not exist");
		}
	}

	public FileNode getDirectory(String name) {
		if (!children.containsKey(name)) {
			System.out.println("Error: Directory '" + name + "' does not exist");
		}
		return children.get(name);
	}

	public String listDirectories() {
		StringBuilder list = new StringBuilder();
		if (children.keySet().size() == 0)
			System.out.println("<empty>");
		children.keySet().stream().forEach(name -> list.append(name + " "));
		return list.toString();
	}

	public boolean isDirectoryPresent(String name) {
		return children.containsKey(name);
	}

	public FileNode getParentDirectory() {
		return parent;
	}

}
