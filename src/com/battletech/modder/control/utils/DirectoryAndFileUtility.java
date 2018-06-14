package com.battletech.modder.control.utils;

import java.io.File;
import java.util.ArrayList;

public class DirectoryAndFileUtility {

	public String						dirPath;
	public String						fileName;
	public SimpleLogger			log;
	private ArrayList<File>	fileNameArray;

	public ArrayList<File> getFileArray() {
		return this.fileNameArray;
	}

	/**
	 * Retrieve the list of files under the given directory and add them to an
	 * ArrayList<File>
	 * 
	 * @param directoryName
	 */
	public void setFileArray(String directoryName) throws NullPointerException {
		try {
			File directory = new File(directoryName);
			// get all the files from a directory
			File[] fList = directory.listFiles();
			for (File file : fList) {
				if (file.isFile()) {
					this.fileNameArray.add(file);
					System.out.println(file.getName());
				}
			}
		} catch (NullPointerException npe) {
			String x = npe.toString();
			log = new SimpleLogger();
			System.out.println(x);
		}
	}
}
