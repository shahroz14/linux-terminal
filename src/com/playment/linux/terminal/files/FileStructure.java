package com.playment.linux.terminal.files;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.playment.linux.terminal.utils.PathUtils;

/**
 * This class represents a file system with root directory.
 * 
 * @author Shahroz Saleem
 *
 */
public class FileStructure {

	/*
	 * ===========================================================================
	 * Fields
	 * ===========================================================================
	 */
	private FileNode root;

	private FileNode currentNode;

	/*
	 * ===========================================================================
	 * Constructors
	 * ===========================================================================
	 */

	public FileStructure() {
		root = new FileNode("/");
		currentNode = root;
	}

	/*
	 * ===========================================================================
	 * Methods
	 * ===========================================================================
	 */

	/**
	 * This method will take to the {@link path} and thereafter all non absolute
	 * path will be relative to this.
	 * 
	 * @param path
	 */
	public void changeDirectory(String path) {
		if (!isValidPath(path)) {
			System.out.println("ERR: INVALID PATH");
			return;
		}
		if (path.startsWith("/"))
			currentNode = root;

		List<String> dirPath = Arrays.stream(path.split("/")).filter(n -> !n.equals("")).collect(Collectors.toList());
		for (String dirName : dirPath) {
			currentNode = currentNode.getDirectory(dirName);
		}

		System.out.println("SUCC: REACHED");
	}

	/**
	 * It returns true if path is valid or else returns false. Path will be
	 * considered absolute if it starts from '/' or else relative to the present
	 * working directory.
	 * 
	 * @param path
	 * @return
	 */
	private boolean isValidPath(String path) {
		path = path.trim();
		FileNode tempNode;
		List<String> dirPath;

		if (path.startsWith("/"))
			tempNode = root;
		else
			tempNode = currentNode;

		dirPath = Arrays.stream(path.split("/")).filter(n -> !n.equals("")).collect(Collectors.toList());
		for (String dirName : dirPath) {
			if (!tempNode.isDirectoryPresent(dirName))
				return false;
			tempNode = tempNode.getDirectory(dirName);
		}
		return true;
	}

	/**
	 * This will create all directories on the path specified followed by directory
	 * name. Ignore all directories which are already present and whose path is
	 * invalid.
	 * 
	 * @param dirNames
	 *            Directories names with which directory has to be created.
	 */
	public void makeDirectories(String... paths) {

		boolean isError = false;
		for (String path : paths) {
			isError = isError | !makeDirectory(path);
		}

		if (!isError)
			System.out.println("SUCC: CREATED");
		else
			System.out.println("ERR: INVALID PATH / DIRECTORY ALREADY EXIST");
	}

	/**
	 * It is used to create a directory on the path specified. Ignore if directory
	 * already exist or path is invalid.
	 * 
	 * @param path
	 *            This is the path where directory will be created. Can be absolute
	 *            or relative.
	 */
	private boolean makeDirectory(String path) {
		path = path.trim();

		String parentPath = PathUtils.getParentPath(path);

		if (!isValidPath(parentPath)) {
			return false;
		}

		FileNode tempNode;
		if (PathUtils.isAbsolutePath(path))
			tempNode = root;
		else
			tempNode = currentNode;

		List<String> parentDirs = Arrays.stream(parentPath.split("/")).filter(n -> !n.equals(""))
				.collect(Collectors.toList());
		for (String parentDir : parentDirs) {
			tempNode = tempNode.getDirectory(parentDir);
		}

		return tempNode.addDirectory(PathUtils.getLastDirectory(path));
	}

	/**
	 * Remove all directories exist on the path specified. Ignore if directory does
	 * not exist or specified path is invalid.
	 * 
	 * @param paths
	 *            This is the path where directory will be created. Can be absolute
	 *            or relative.
	 */
	public void removeDirectories(String... paths) {

		boolean isError = false;
		for (String path : paths) {
			isError = isError | !removeDirectory(path);
		}

		if (!isError)
			System.out.println("SUCC: DELETED");
		else
			System.out.println("ERR: INVALID PATH / DIRECTORY DOES NOT EXIST");
	}

	/**
	 * Removes a directory exist on the path specified. Ignore if directory does not
	 * exist or specified path is invalid.
	 * 
	 * @param path
	 *            This is the path from where directory is to be removed. Specified
	 *            Path can be absolute or relative.
	 */
	private boolean removeDirectory(String path) {
		path = path.trim();

		String parentPath = PathUtils.getParentPath(path);

		if (!isValidPath(parentPath)) {
			return false;
		}

		FileNode tempNode;
		if (PathUtils.isAbsolutePath(path))
			tempNode = root;
		else
			tempNode = currentNode;

		List<String> parentDirs = Arrays.stream(parentPath.split("/")).filter(n -> !n.equals(""))
				.collect(Collectors.toList());
		for (String parentDir : parentDirs) {
			tempNode = tempNode.getDirectory(parentDir);
		}

		return tempNode.removeDirectory(PathUtils.getLastDirectory(path));
	}

	/**
	 * List all directories inside the present working directory.
	 */
	public void listDirectories() {
		System.out.println("DIRS: " + currentNode.listDirectories());
	}

	/**
	 * List the present working directory path.
	 */
	public void getCurrentDirectoryPath() {
		FileNode node = currentNode;
		StringBuilder pwd = new StringBuilder();
		boolean lastNode = true;
		while (!node.getName().equals("/")) {
			pwd.insert(0, node.getName() + (!lastNode ? "/" : ""));
			lastNode = false;
			node = node.getParentDirectory();
		}
		System.out.println("PATH: /" + pwd);
	}

	public void clearSession() {
		root = new FileNode("/");
		currentNode = root;
		System.out.println("SUCC: CLEARED: RESET TO ROOT");
	}

}
