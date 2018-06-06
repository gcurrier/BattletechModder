package com.battletech.modder.view;

import java.io.File;

import com.battletech.modder.BTModderMain;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
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
				setWeaponTab();
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

	@FXML
	public void setWeaponTab() {
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());				
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
