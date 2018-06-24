package com.battletech.modder.view;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class WeaponDataController {
	public WeaponDataController() {}

	/**
	 * 
	 * @param fileName
	 */
	public static JSONObject getWeaponData(String fileFullPath) {
		JSONObject wpnData = null;
		JSONTokener jt = null;
		try {
			jt = new JSONTokener(new FileReader(fileFullPath));
			wpnData = new JSONObject(jt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return wpnData;
	}

	public void displayWeaponData() {
	}

	public void editWeaponData() {
	}

	public void saveWeaponData() {
	}

}
