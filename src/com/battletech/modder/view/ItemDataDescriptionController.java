package com.battletech.modder.view;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.battletech.modder.model.Description;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;

public class ItemDataDescriptionController {

	private TableView<Description>						itemDescTable;
	private TableColumn<Description, String>	itemCategoryCol;
	private TableColumn<Description, String>	itemDetailCol;
	private TextArea													itemDetailText;
	private Label															itemsTabLabel;

	public ItemDataDescriptionController() {
	}

	/**
	 * 
	 * @param fileName
	 */
	public static JSONObject getItemData(String fileFullPath) {
		JSONObject itemData = null;
		JSONTokener jt = null;
		try {
			jt = new JSONTokener(new FileReader(fileFullPath));
			itemData = new JSONObject(jt);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return itemData;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getItemDataDisplay(ObservableList<Description> descriptionListData, TreeItem<String> obsVal, String tabType, String componentPath) {

		// IN setItemTable((TreeItem<String>) obs.getValue(),String tabType,String
		// getComponentFullPath()) OUT
		// (ObservableList<Description>,TableColumn<Description,
		// String>,TableColumn<Description, String>)
		try {
			TreeItem<String> selectedItem = (TreeItem<String>) obsVal;
			boolean hasParent = selectedItem.getParent() == null ? false : true;
			boolean hasChildren = selectedItem.getChildren().isEmpty() ? false : true;
			boolean selItemIsLeaf = selectedItem.isLeaf();
			String fileFullPath = "";

			if (hasParent && !hasChildren) {
				if (tabType != "upgrades") {
					fileFullPath = componentPath + "\\" + selectedItem.getValue();
				} else {
					fileFullPath = selItemIsLeaf ? componentPath + "\\" + selectedItem.getParent().getParent().getValue() + "\\" + selectedItem.getValue()
							: componentPath + "\\" + selectedItem.getValue();
				}
				JSONObject weaponData = getItemData(fileFullPath);
				try {
					JSONObject description = (JSONObject) weaponData.get("Description");
					JSONArray descArr = description.names();
					// clear the list before refilling it with new data
					descriptionListData.removeAll(descriptionListData);
					// remove columns
					itemDescTable.getColumns().clear();
					for (int i = 0; i < descArr.length(); i++) {
						String descKey = descArr.getString(i);
						String descVal = description.getString(descKey);
						if (descKey.equals("Details")) {
							itemDetailText.setText(descVal);
							itemDetailText.setWrapText(true);
							itemDetailText.setEditable(false);
						} else if (descKey.equals("Name")) {
							itemsTabLabel.setText(descVal);
						} else {
							// populate Observable list with Description data
							descriptionListData.add(new Description(descKey.toString(), descVal.toString()));
						}
						// System.out.println(descKey + ": " + descVal);
					}
					// re establish columns
					itemCategoryCol = new TableColumn("Category");
					itemCategoryCol.setCellValueFactory(new PropertyValueFactory<Description, String>("key"));

					itemDetailCol = new TableColumn("Detail");
					itemDetailCol.setCellValueFactory(new PropertyValueFactory<Description, String>("value"));

					itemDescTable.setItems(descriptionListData);
					itemDescTable.getColumns().addAll(itemCategoryCol, itemDetailCol);
					itemDescTable.setEditable(true);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				// return a Description table and additional items
				// TODO 2 new classes with constructors, getters and setters
				// return new DescriptionDisplay(new ItemDataDescription,ItemDataDescription(descriptionListData,itemCategoryCol,itemDetailCol),itemDetailText,itemsTabLabel)
			}
		} catch (NullPointerException npe) {
			System.out.println("Opening " + tabType + " at root level.");
		}

	}

	public void editItemData() {
	}

	public void saveItemData() {
	}

}
