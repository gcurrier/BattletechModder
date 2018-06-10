package com.battletech.modder.control.utils;

import com.battletech.modder.model.Heatsink;

import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

public class HeatsinkTableUtil {

	// public static TreeItem<Heatsink> getModel(){
	//
	// }

	public static TreeTableColumn<Heatsink, String> getManufacturerColumn() {
		TreeTableColumn<Heatsink, String> col = new TreeTableColumn<>("Manufacturer");
		col.setCellValueFactory(new TreeItemPropertyValueFactory<>("manuf"));
		return col;
	}
	
	public static TreeTableColumn<Heatsink, String> getModelColumn() {
		TreeTableColumn<Heatsink, String> col = new TreeTableColumn<>("Model");
		col.setCellValueFactory(new TreeItemPropertyValueFactory<>("model"));
		return col;
	}
	
	public static TreeTableColumn<Heatsink, String> getNameColumn() {
		TreeTableColumn<Heatsink, String> col = new TreeTableColumn<>("Name");
		col.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
		return col;
	}
	
	public static TreeTableColumn<Heatsink, String> getIdColumn() {
		TreeTableColumn<Heatsink, String> col = new TreeTableColumn<>("FileId");
		col.setCellValueFactory(new TreeItemPropertyValueFactory<>("fileName"));
		return col;
	}
}
