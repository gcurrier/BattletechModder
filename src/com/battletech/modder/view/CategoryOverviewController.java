package com.battletech.modder.view;

import java.io.File;

import com.battletech.modder.BTModderMain;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
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
		setAllTabs(tabPane.getTabs());
		tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
			@Override
			public void changed(ObservableValue<? extends Tab> oldValue, Tab tabOld, Tab tabNew) {
				setActiveTabText(tabNew.getText());
				setComponentFullPath(getSelectedDirectoryPath() + "\\" + getActiveTabText());
				updateDirectoryLabel(getActiveTabText());
				updateTabDisplay(getActiveTabText());
			}
		});
	}

	/**
	 * Update the parent view directory label with the selected tab's component
	 * folder path or set an instructional message
	 * 
	 * @param selectedTabName
	 */
	private void updateDirectoryLabel(String selectedTabName) {
		File selectedDirectory = RootLayoutController.selectedDirectory;
		String tabName;
		tabName = selectedTabName != null ? selectedTabName : "<selected tab>";
		if (selectedDirectory != null) {
			String currentSelectedDirectoryPath = getSelectedDirectoryPath();
			getBtModder().rootController.setLabelConfigDirText(currentSelectedDirectoryPath + "\\" + tabName);
		}
		// else {
		// updateDirectoryLabelWithMessage("Please select a folder from the
		// \"Directory\" -> \"Open...\" menu.");
		// }
	}

//	/**
//	 * Update the parent view directory label with an instructional message
//	 * 
//	 * @param msg
//	 */
//	private void updateDirectoryLabelWithMessage(String msg) {
//		getBtModder().rootController.setLabelConfigDirText(msg);
//	}
//
//	public void setInitialView() {
//		tabPane.getSelectionModel().select(0);
//	}

	/**
	 * Update the directory display label according to the tab selected
	 * 
	 * @param tabName
	 */
	private void updateTabDisplay(String tabName) {
		switch (tabName) {
		case "weapon":
			updateDirectoryLabel(tabName);
			weaponsTabLabel.setText("(setTabDisplay): Weapons Data Display");
			break;
		case "shops":
			updateDirectoryLabel(tabName);
			shopsTabLabel.setText("(setTabDisplay): Shops Data Display");
			break;
		case "heatsinks":
			updateDirectoryLabel(tabName);
			heatsinksTabLabel.setText("(setTabDisplay): Heatsinks Data Display");
			break;
		case "upgrades":
			updateDirectoryLabel(tabName);
			upgradesTabLabel.setText("(setTabDisplay): Upgrades Data Display");
			break;
		case "mech":
			updateDirectoryLabel(tabName);
			mechsTabLabel.setText("(setTabDisplay): Mechs Data Display");
			break;
		default:
			updateDirectoryLabel(tabName);
			break;
		}
	}

	/**
	 * @return the componentFullPath
	 */
	public String getSelectedDirectoryPath() {
		// return getBtModder().rootController.getSelectedDirectory().getAbsolutePath();
		return RootLayoutController.selectedDirectory.getAbsolutePath();
	}

	public String getComponentFullPath() {
		return CategoryOverviewController.componentFullPath;
	}

	/**
	 * @param selectedDirectory
	 *            the selectedDirectory to set
	 */
	public void setComponentFullPath(String componetFullPath) throws NullPointerException {
		try {
			CategoryOverviewController.componentFullPath = componetFullPath;
		} catch (NullPointerException npe) {
			System.out.println("No Directory Selected");
		}
	}

	@FXML
	private void setMechsTab() {
		System.out.println("Mechs tab initialized");
	}

	@FXML
	private void setShopsTab() {
		System.out.println("Shops tab initialized");
	}

	@FXML
	private void setHeatsinksTab() {
		System.out.println("Heatsinks tab initialized");
	}

	@FXML
	private void setUpgradesTab() {
		System.out.println("Upgrades tab initialized");
	}

	@FXML
	public void setWeaponTab() {
		try {
		if (RootLayoutController.selectedDirectory.exists()) {
			System.out.println(getComponentFullPath());
			System.out.println("[setWeaponTab]: Weapons tab initialized");
		} else {
			System.out.println("[setWeaponTab] No Directory yet selected.");
		}
		}
		catch(NullPointerException npe) {
			System.out.println("[setWeaponTab]: No directory selected - causing null pointer exception");
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
