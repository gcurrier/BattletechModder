package com.battletech.modder.control.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import javafx.scene.control.TreeItem;

public class TreeViewBuilder {

	/**
	 * Expects an absolute path string to a folder containing .json files. If files
	 * are found, will parse .json files into a JSONObject and add the object to an
	 * ArrayList.
	 * 
	 * @param componentFolderPath
	 *          The absolutePath string
	 * @return ArrayList<JSONObject>
	 */
	public static ArrayList<JSONObject> getItemList(String componentFolderPath) {
		ArrayList<JSONObject> itemList = new ArrayList<JSONObject>();

		File directory = new File(componentFolderPath);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				Path path = file.toPath();
				List<String> files;
				try {
					files = Files.readAllLines(path);
					String thisFile = files.toString().replaceAll(",,", ",").replaceAll("^\\[", "").replaceAll("\\]$", "").replaceAll("\\{,", "\\{");
					JSONObject item;
					item = new JSONObject(thisFile);
					itemList.add(item);
				} catch (Exception e) {
					itemList.add(new JSONObject());
					e.printStackTrace();
				}
			}
		}
		return itemList;
	}

	/**
	 * Method to return a TreeItem<String> object, based on category. The
	 * description JSONObject is passed along to a subsequent method call for
	 * building category-specific nested TreeItems.
	 * 
	 * @param category
	 *          The name of the TreeView branch (used to determine which subsequent
	 *          TreeItem builder to call)
	 * @param description
	 *          The JSONObject representing the Description nested object (assumed
	 *          to be present) within the file currently being "read".
	 * @return TreeItem
	 */
	@SuppressWarnings("null")
	public static TreeItem<String> getTreeViewBranch(String category, JSONObject description) {
		TreeItem<String> thisItem = null;
		switch (category.toLowerCase()) {
		case "missile":
			thisItem = getGenericTreeItem(description);
			break;
		case "energy":
			thisItem = getGenericTreeItem(description);
			break;
		case "ballistic":
			thisItem = getGenericTreeItem(description);
			break;
		case "antipersonnel":
			thisItem = getGenericTreeItem(description);
			break;
		case "melee":
			thisItem = getGenericTreeItem(description);
			break;
		case "heatsinks":
			thisItem = getGenericTreeItem(description);
			break;
		case "gyros":
			thisItem = getGenericTreeItem(description);
			break;
		case "actuators":
			thisItem = getGenericTreeItem(description);
			break;
		case "cockpitmods":
			thisItem = getGenericTreeItem(description);
			break;
		case "targettrackingsystem":
			thisItem = getGenericTreeItem(description);
			break;
		case "not set":
			break;
		case "":
			break;
		default:
			break;
		}
		return thisItem;
	}

	/**
	 * Generic method to return a Tree Item Leaf. Accepts a JSON object as a parameter. 
	 * 
	 * @param {JSONObject} description
	 * @return TreeItem<String>
	 */
	private static TreeItem<String> getGenericTreeItem(JSONObject description){
		TreeItem<String> thisItem = null;
		TreeItem<String> fileNameItem;
		String manufacturer = null, itemName = null, fileName, thisLeafName = null;
		try {
			if (!((description).get("Manufacturer").equals(null))) {
				manufacturer = "(" + (description).get("Manufacturer").toString() + ")";
			} else {
				manufacturer = null;
			}
		} catch (JSONException je) {
			manufacturer = null;
		}
		try {
			if (!((description).get("Name").equals(null))) {
				itemName = (description).get("Name").toString();
			} else {
				itemName = null;
			}
		} catch (JSONException je) {
			itemName = null;
		}
		try {
			fileName = (description).get("Id").toString() + ".json";
		} catch (JSONException je) {
			fileName = " ";
		}
		if (manufacturer != null && itemName == null) {
			thisLeafName = manufacturer;
		}
		if (manufacturer == null && itemName != null) {
			thisLeafName = itemName;
		}
		if (manufacturer == null && itemName == null) {
			thisLeafName = null;
		}
		if (manufacturer != null && itemName != null) {
			thisLeafName = manufacturer + " " + itemName;
		}
		if (thisLeafName != null) {
			thisItem = new TreeItem<>(thisLeafName);
			fileNameItem = new TreeItem<String>(fileName);
			thisItem.getChildren().add(fileNameItem);
		} else {
			thisItem = new TreeItem<>("-");
		}
		return thisItem;
	}
}
