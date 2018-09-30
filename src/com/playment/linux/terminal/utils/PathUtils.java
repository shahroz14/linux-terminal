package com.playment.linux.terminal.utils;

/**
 * All utilities related to path goes here.
 * 
 * @author Shahroz Saleem
 *
 */
public class PathUtils {

	public static boolean isAbsolutePath(String path) {
		return path.startsWith("/");
	}

	public static String getLastDirectory(String path) {
		return path.substring(path.lastIndexOf("/") + 1);
	}

	public static String getParentPath(String path) {
		return path.substring(0, path.lastIndexOf("/") + 1);
	}

}
