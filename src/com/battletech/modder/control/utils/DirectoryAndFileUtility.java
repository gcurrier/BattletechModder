package com.battletech.modder.control.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.battletech.modder.BTModderMain;
import com.battletech.modder.model.Description;
import com.battletech.modder.model.Weapon;

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
	 * Reads the data in the file at the file path given and converts the data to a
	 * JSONObject and returns it.
	 * 
	 * @param AbsPathToFile
	 *          The absolute path to the source file
	 * @return JSONObject
	 */
	public static JSONObject getSourceJson(String AbsPathToFile) {
		JSONObject json = null;
			try {
				InputStream is = new FileInputStream(AbsPathToFile);
				String jsonTxt = IOUtils.toString(is, "UTF-8");
				json = new JSONObject(jsonTxt);
			} catch (Exception e) {
				e.printStackTrace();
			}

		return json;
	}

	/**
	 * Saves json data to the app backup data directory
	 * 
	 * @param jsonData
	 *          The json data object to save
	 * @param fileName
	 *          The name of the file to save as (must be the same name and extension
	 *          as original)
	 * @return
	 */
	public static Boolean saveJsonToFile(JSONObject jsonData, String componentType, String fileName) {
		boolean isSaved = false;
		String username = System.getProperty("user.name");
		String dateTimePattern = "yyyyMMdd'T'HHmm";
		String dayPattern = "yyyyMMdd";
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dayPattern);
		String formattedDateTime = localDateTime.format(formatter);
		String sessionUID = BTModderMain.sessionUID;
		Path backupPath = Paths.get("C:\\Users\\" + username + "\\AppData\\Local\\BattletechModder\\app\\backup\\" + sessionUID + "\\data\\" + componentType);
		String newFilePath = "";
		Writer output = null;
		try {
			if (!Files.exists(backupPath)) {
				Files.createDirectories(backupPath);
			}
			newFilePath = backupPath.toString() + "\\" + fileName;
			String jsonString = jsonData.toString(4);
			File file = new File(newFilePath);
			output = new BufferedWriter(new FileWriter(file));
			output.write(jsonString);
			output.close();
			if (file.exists()) {
				System.out.println(formattedDateTime + ": Original of " + fileName + " saved to " + newFilePath);
				isSaved = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSaved;
	}

	/**
	 * Performs save file actions (copy original, create new file with updated data,
	 * move original to backup, save new to origin location)
	 * 
	 * @param dataCategory
	 *          One of "weapon","heatsink","upgrade".
	 * @param fullFilePath
	 *          The complete absolute path of originating file.
	 * @param itemTableColumns
	 *          An observable list of a displayed table.
	 * @param itemText
	 *          Detail or description text as part of the data display.
	 */
	@SuppressWarnings("unused")
	public static Boolean saveFile(String dataCategory, String fullFilePath, ObservableList<TableColumn<Description, ?>> itemTableColumns,
			String itemText) {
		boolean isSaved = false;
		String filename = "";
		JSONObject jsonData = getSourceJson(fullFilePath);
		try {
			JSONObject description = (JSONObject) jsonData.get("Description");
			filename = description.get("Id").toString() + ".json";
		} catch (JSONException e) {
			e.printStackTrace();
		}
		switch (dataCategory) {
		case "weapon":
			//TODO get all "Description" keys from jsonData and and update with itemTableColumns
			//TODO get all other data from jsonData and add to new Weapon
			Weapon newWeapon = new Weapon(jsonData,true);
			break;
		case "heatsink":
			break;
		case "upgrade":
			break;
		default:
			break;
		}
		// get original file and parse into json object (hold in a variable)
		// TODO iterate through new json object and update where necessary
		// TODO save new json object data to new file in original directory
		isSaved = saveJsonToFile(jsonData, dataCategory, filename);

		return isSaved;
	}

}
