package com.battletech.modder.view;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.battletech.modder.BTModderMain;
//import com.battletech.modder.model.Weapon;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class CategoryOverviewController {

	@FXML
	private TabPane tabPane;
	@FXML
	private SplitPane splitPane;
	@FXML
	private TreeView<?> treeView;
	@FXML
	private Button editBtn;
	@FXML
	private Button saveBtn;
	@FXML
	private Button cancelBtn;
	@FXML
	private Label weaponsTabLabel;
	@FXML
	private Label shopsTabLabel;
	@FXML
	private Label mechsTabLabel;
	@FXML
	private Label heatsinksTabLabel;
	@FXML
	private Label upgradesTabLabel;

	private ObservableList<Tab> allTabs;
	private BTModderMain btModder;

	public static String activeTabText;
	public static String componentFullPath;
	public static int selectedTabIdx = 0;

	/**
	 * Empty constructor. The constructor is called before the initialize() method.
	 */
	public CategoryOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded. Creates a listener on tab selection change.
	 */
	@FXML
	private void initialize() {
		// EventHandler<Event> configureSelectedTab = event -> {
		// selectedTabIdx = tabPane.getSelectionModel().getSelectedIndex();
		//
		// Tab currentTab = (Tab) event.getTarget();
		// if (currentTab.isSelected()) {
		// System.out.println(currentTab.getText() + " is currently selected");
		// }
		// };
		setAllTabs(tabPane.getTabs());
		tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			setActiveTabText(newTab.getText());
			switch (newTab.getText()) {
			case "Weapon":
				weaponsTabLabel.setText("(setTabDisplay): Weapons Data Display");
				try {
					setWeaponTab();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "Heatsinks":
				heatsinksTabLabel.setText("(setTabDisplay): Heatsinks Data Display");
				setHeatsinksTab();
				break;
			case "Upgrades":
				upgradesTabLabel.setText("(setTabDisplay): Upgrades Data Display");
				setUpgradesTab();
				break;
			case "Shops":
				shopsTabLabel.setText("(setTabDisplay): Shops Data Display");
				setShopsTab();
				break;
			case "Mech":
				mechsTabLabel.setText("(setTabDisplay): Mechs Data Display");
				setMechsTab();
				break;
			}
			setComponentFullPath(getSelectedDirectoryPath() + "\\" + getActiveTabText());
			updateDirectoryLabel(getActiveTabText());
		});
	}

	/**
	 * Update the parent view directory label with the selected tab's component
	 * folder path or set an instructional message
	 * 
	 * @param selectedTabName
	 */
	private void updateDirectoryLabel(String selectedTabName) {
		File selectedDirectory = getBtModder().rootController.getSelectedDirectory();
		String tabName;
		tabName = selectedTabName != null ? selectedTabName : "<selected tab>";
		if (selectedDirectory != null) {
			String currentSelectedDirectoryPath = getSelectedDirectoryPath();
			getBtModder().rootController.setLabelConfigDirText(currentSelectedDirectoryPath + "\\" + tabName);
		}
	}

	/**
	 * @return the componentFullPath
	 */
	public String getSelectedDirectoryPath() throws NullPointerException {
		try {
			return getBtModder().rootController.getSelectedDirectory().getAbsolutePath();
		} catch (NullPointerException npe) {
			System.out.println("[getSelectedDirectoryPath]: No directory selected");
			return "";
		}
	}

	public String getComponentFullPath() {
		// return CategoryOverviewController.componentFullPath;
		return getSelectedDirectoryPath() + "\\" + getActiveTabText();
	}

	/**
	 * @param selectedDirectory
	 *            the selectedDirectory to set
	 */
	public void setComponentFullPath(String componetFullPath) throws NullPointerException {
		try {
			CategoryOverviewController.componentFullPath = componetFullPath;
		} catch (NullPointerException npe) {
			System.out.println("[setComponentFullPath]: No Directory Selected");
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void setWeaponTab() throws NullPointerException, IOException, JSONException {
		ArrayList<JSONObject> weaponList = new ArrayList<JSONObject>();
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
				try {
					File directory = new File(getComponentFullPath());
					// get all the files from a directory
					File[] fList = directory.listFiles();
					for (File file : fList) {
						if (file.isFile()) {
							Path path = file.toPath();
							List<String> files = Files.readAllLines(path);
							String thisFile = files.toString().replaceAll(",,", ",").replaceAll("^\\[", "")
									.replaceAll("\\]$", "").replaceAll("\\{,", "\\{");
							// System.out.println(thisFile);
							JSONObject wpn = new JSONObject(thisFile);
							weaponList.add(wpn);
						}
					}
					TreeItem<String> rootItem = new TreeItem<>("Weapons");
					TreeItem<String> energyItems = new TreeItem<>("Energy");
					TreeItem<String> missileItems = new TreeItem<>("Missile");
					TreeItem<String> ballisticItems = new TreeItem<>("Ballistic");
					TreeItem<String> antiPersonnelItems = new TreeItem<>("AntiPersonnel");
					TreeItem<String> meleeItems = new TreeItem<>("Melee");
					rootItem.getChildren().addAll(energyItems, missileItems, ballisticItems, antiPersonnelItems,
							meleeItems);

					for (JSONObject weapon : weaponList) {
						if (weapon.get("Category") == "Missile") {
							JSONObject description = (JSONObject) weapon.get("Description");
							String itemName = description.getString("Name");
							TreeItem<String> thisWeapon = new TreeItem<>(itemName);
							missileItems.getChildren().add(thisWeapon);
						}
						if (weapon.get("Category") == "AntiPersonnel") {
							JSONObject description = (JSONObject) weapon.get("Description");
							String itemName = description.getString("Name");
							TreeItem<String> thisWeapon = new TreeItem<>(itemName);
							antiPersonnelItems.getChildren().add(thisWeapon);
						}
						if (weapon.get("Category") == "Energy") {
							JSONObject description = (JSONObject) weapon.get("Description");
							String itemName = description.getString("Name");
							TreeItem<String> thisWeapon = new TreeItem<>(itemName);
							energyItems.getChildren().add(thisWeapon);
						}
						if (weapon.get("Category") == "Ballistic") {
							JSONObject description = (JSONObject) weapon.get("Description");
							String itemName = description.getString("Name");
							TreeItem<String> thisWeapon = new TreeItem<>(itemName);
							ballisticItems.getChildren().add(thisWeapon);
						}
						if (weapon.get("Category") == "Melee") {
							JSONObject description = (JSONObject) weapon.get("Description");
							String itemName = description.getString("Name");
							TreeItem<String> thisWeapon = new TreeItem<>(itemName);
							meleeItems.getChildren().add(thisWeapon);
						}
					}
					
//					treeView.getChildrenUnmodifiable();
					this.treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// TODO
		} catch (NullPointerException npe) {
			System.out.println("[setWeaponTab]: No directory selected");
		}
	}

	@FXML
	private void setShopsTab() throws NullPointerException {
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
			}
			// TODO
		} catch (NullPointerException npe) {
			System.out.println("[setShopsTab]: No directory selected");
		}
	}

	@FXML
	private void setHeatsinksTab() throws NullPointerException {
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
			}
			// TODO
		} catch (NullPointerException npe) {
			System.out.println("[setHeatsinksTab]: No directory selected");
		}
	}

	@FXML
	private void setUpgradesTab() throws NullPointerException {
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
			}
			// TODO
		} catch (NullPointerException npe) {
			System.out.println("[setUpgradesTab]: No directory selected");
		}
	}

	@FXML
	private void setMechsTab() throws NullPointerException {
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
			}
			// TODO
		} catch (NullPointerException npe) {
			System.out.println("[setMechsTab]: No directory selected");
		}
	}

	public ObservableList<Tab> getAllTabs() {
		return allTabs;
	}

	public void setAllTabs(ObservableList<Tab> allTabs) {
		this.allTabs = allTabs;
	}

	@FXML
	private void handleEdit() {
		System.out.println("Edit Button Clicked");
	}

	@FXML
	private void handleSave() {
		System.out.println("Save Button Clicked");
	}

	@FXML
	private void handleCancel() {
		System.out.println("Cancel Button Clicked");
	}

	/**
	 * Called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(BTModderMain btModder) {
		this.setBtModder(btModder);
	}

	/**
	 * @return the btModder
	 */
	public BTModderMain getBtModder() {
		return btModder;
	}

	/**
	 * @param btModder
	 *            the btModder to set
	 */
	public void setBtModder(BTModderMain btModder) {
		this.btModder = btModder;
	}

	/**
	 * @return the activeTab text name
	 */
	public String getActiveTabText() {
		return CategoryOverviewController.activeTabText;
	}

	/**
	 * @param activeTabText
	 *            the activeTabText to set
	 */
	public void setActiveTabText(String activeTabText) {
		CategoryOverviewController.activeTabText = activeTabText.toLowerCase();
	}

	/**
	 * @return the activeTab
	 */
	public Tab getActiveTab() {
		Tab activeTab = tabPane.getSelectionModel().getSelectedItem();
		return activeTab;
	}
}
