package com.battletech.modder.control.utils;

import java.io.File;
import java.util.ArrayList;

import com.battletech.modder.model.Description;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

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

	/**
	 * Performs save file actions (copy original, create new file with updated data, move original to backup, save new to origin location)
	 * 
	 * @param dataCategory One of "weapon","heatsink","upgrade".
	 * @param fullFilePath The complete absolute path of originating file.
	 * @param itemTableColumns An observable list of a displayed table.
	 * @param itemText Detail or description text as part of the data display.
	 */
	public static Boolean saveFile(String dataCategory, String fullFilePath, ObservableList<TableColumn<Description,?>> itemTableColumns, String itemText) {
		boolean isSaved = false;
		//get original file and parse into json object (hold in a variable)
		//TODO iterate through new json object and update where necessary
		//TODO create save directory if it doesn't already exist
		//TODO Copy original file to subfolder (with date) in save directory
		//TODO save new json object data to new file in original directory
		//TODO return true if successfully saved, false if not
		System.out.println("Saving an item...");
		return isSaved;
	}
	
}
