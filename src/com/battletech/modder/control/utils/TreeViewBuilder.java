package com.battletech.modder.control.utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
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
			thisItem = getWeaponTreeItem(description);
			break;
		case "energy":
			thisItem = getWeaponTreeItem(description);
			break;
		case "ballistic":
			thisItem = getWeaponTreeItem(description);
			break;
		case "antipersonnel":
			thisItem = getWeaponTreeItem(description);
			break;
		case "melee":
			thisItem = getWeaponTreeItem(description);
			break;
		case "heatsinks":
			thisItem = getHeatsinkTreeItem(description);
			break;
		case "gyros":
			thisItem = getUpgradeTreeItem(description);
			break;
		case "actuators":
			thisItem = getUpgradeTreeItem(description);
			break;
		case "cockpitmods":
			thisItem = getUpgradeTreeItem(description);
			break;
		case "targettrackingsystem":
			thisItem = getUpgradeTreeItem(description);
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
	 * Method to return weapon-specific tree items.
	 * 
	 * @param description
	 * @return TreeItem
	 */
	private static TreeItem<String> getWeaponTreeItem(JSONObject description) {
		TreeItem<String> thisItem = null;
		TreeItem<String> fileNameItem;
		String itemName, manufacturer, thisLeafName, fileName;
		try {
			manufacturer = (description).get("Manufacturer").toString();
		} catch (org.json.JSONException oje) {
			manufacturer = " ";
		}
		try {
			fileName = (description).get("Id").toString() + ".json";
			itemName = (description).get("Name").toString();
			thisLeafName = "(" + manufacturer + ") " + itemName;
			thisItem = new TreeItem<String>(thisLeafName);
			fileNameItem = new TreeItem<String>(fileName);
			thisItem.getChildren().add(fileNameItem);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return thisItem;
	}

	/**
	 * Method to return heatsink-specific tree items.
	 * 
	 * @param description
	 * @return TreeItem
	 */
	private static TreeItem<String> getHeatsinkTreeItem(JSONObject description) {
		TreeItem<String> thisItem = null;
		TreeItem<String> fileNameItem;
		String manufacturer, itemName, fileName, thisLeafName;
		try {
			manufacturer = (description).get("Manufacturer").toString();
		} catch (JSONException je) {
			manufacturer = " ";
		}
		try {
			itemName = (description).get("Name").toString();
		} catch (JSONException je) {
			itemName = " ";
		}
		try {
			fileName = (description).get("Id").toString();
		} catch (JSONException je) {
			fileName = " ";
		}
		try {
			fileName = (description).get("Id").toString() + ".json";
			itemName = (description).get("Name").toString();
			thisLeafName = "(" + manufacturer + ") " + itemName;
			thisItem = new TreeItem<>(thisLeafName);
			fileNameItem = new TreeItem<String>(fileName);
			thisItem.getChildren().add(fileNameItem);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return thisItem;
	}

	private static TreeItem<String> getUpgradeTreeItem(JSONObject description) {
		TreeItem<String> thisItem = null;
		TreeItem<String> fileNameItem;
		String manufacturer, itemName, fileName, thisLeafName;
		try {
			manufacturer = (description).get("Manufacturer").toString();
		} catch (JSONException je) {
			manufacturer = " ";
		}
		try {
			itemName = (description).get("Name").toString();
		} catch (JSONException je) {
			itemName = " ";
		}
		try {
			fileName = (description).get("Id").toString() + ".json";
		} catch (JSONException je) {
			fileName = " ";
		}
		thisLeafName = "(" + manufacturer + ") " + itemName;
		thisItem = new TreeItem<>(thisLeafName);
		fileNameItem = new TreeItem<String>(fileName);
		thisItem.getChildren().add(fileNameItem);
		return thisItem;
	}
}
