package com.battletech.modder.view;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.json.JSONObject;

import com.battletech.modder.BTModderMain;
import com.battletech.modder.control.utils.TreeViewBuilder;

//TreeTableView imports
//import com.battletech.modder.model.Heatsink;
//import com.battletech.modder.model.Weapon;
//import javafx.beans.property.ReadOnlyStringWrapper;
//import javafx.scene.control.TreeTableColumn;
//import javafx.scene.control.TreeTableView;
//import java.util.Arrays;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class CategoryOverviewController {

	// Components belonging to the Parent Tab Pane
	@FXML
	private TabPane tabPane;

	// Weapons Tab components and children
	@FXML
	private Tab weaponTab;
	@FXML
	private SplitPane weaponSplitPane;
	@FXML
	private AnchorPane weaponsLHSAnchorPane;
	@FXML
	private TreeView<String> weaponTreeView;
	@FXML
	private Label weaponsTabLabel;

	// Heatsinks Tab components and children
	// @FXML
	// private TreeTableView<Heatsink> heatsinksTreeTableView;
	@FXML
	private Tab heatsinksTab;
	@FXML
	private SplitPane heatsinksSplitPane;
	@FXML
	private AnchorPane heatsinksLHSAnchorPane;
	@FXML
	private TreeView<String> heatsinksTreeView;
	@FXML
	private Label heatsinksTabLabel;

	// Upgrades Tab components and children
	@FXML
	private Tab upgradesTab;
	@FXML
	private SplitPane upgradesSplitPane;
	@FXML
	private AnchorPane upgradesLHSAnchorPane;
	@FXML
	private TreeView<String> upgradesTreeView;
	@FXML
	private Label upgradesTabLabel;

	// Shops Tab components and children
	@FXML
	private Tab shopsTab;
	@FXML
	private SplitPane shopsSplitPane;
	@FXML
	private AnchorPane shopsLHSAnchorPane;
	@FXML
	private TreeView<String> shopsTreeView;
	@FXML
	private Label shopsTabLabel;	
	
	// Mech Tab components and children
	@FXML
	private Tab mechTab;
	@FXML
	private SplitPane mechSplitPane;
	@FXML
	private AnchorPane mechLHSAnchorPane;
	@FXML
	private TreeView<String> mechTreeView;
	@FXML
	private Label mechsTabLabel;
	
	@FXML
	private Button editBtn;
	@FXML
	private Button saveBtn;
	@FXML
	private Button cancelBtn;

	private ObservableList<Tab> allTabs;
	private Node selectedTabContent;
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
		setAllTabs(tabPane.getTabs());
		tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			setActiveTabText(newTab.getText());
			switch (newTab.getText()) {
			case "Weapon":
				weaponsTabLabel.setText("(setTabDisplay): Weapons Data Display");
				setWeaponTreeView();
				break;
			case "Heatsinks":
				heatsinksTabLabel.setText("(setTabDisplay): Heatsinks Data Display");
				setHeatsinksTreeView();
				break;
			case "Upgrades":
				upgradesTabLabel.setText("(setTabDisplay): Upgrades Data Display");
				setUpgradesTreeView();
				break;
			case "Shops":
				shopsTabLabel.setText("(setTabDisplay): Shops Data Display");
				setShopsTreeView();
				break;
			case "Mech":
				mechsTabLabel.setText("(setTabDisplay): Mechs Data Display");
				setMechsTreeView();
				break;
			}
			setComponentFullPath(getSelectedDirectoryPath() + "\\" + getActiveTabText());
			updateDirectoryLabel(getActiveTabText());
		});
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

	public Node getSelectedTabContent() {
		return this.selectedTabContent;
	}

	public void setSelectedTabContent(String tabName) {
		for (int i = 0; i < this.allTabs.size(); i++) {
			String arrTabName = "";
			arrTabName = this.allTabs.get(i).getText().toLowerCase();
			if (arrTabName == tabName.toLowerCase()) {
				switch (arrTabName) {
				case "weapon":
					this.selectedTabContent = this.allTabs.get(i).getContent();
					break;
				case "heatsinks":
					this.selectedTabContent = this.allTabs.get(i).getContent();
					break;
				case "upgrades":
					this.selectedTabContent = this.allTabs.get(i).getContent();
					break;
				case "shops":
					this.selectedTabContent = this.allTabs.get(i).getContent();
					break;
				case "mech":
					this.selectedTabContent = this.allTabs.get(i).getContent();
					break;
				default:
					break;
				}
			}
		}
	}

	public ObservableList<Tab> getAllTabs() {
		return allTabs;
	}

	public void setAllTabs(ObservableList<Tab> allTabs) {
		this.allTabs = allTabs;
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

	@SuppressWarnings({ "unchecked" })
	@FXML
	private void setWeaponTreeView() throws NullPointerException {
		ArrayList<JSONObject> weaponList;
		TreeItem<String> rootItem = new TreeItem<>("Weapons");
		TreeItem<String> energyItems = new TreeItem<>("Energy");
		TreeItem<String> missileItems = new TreeItem<>("Missile");
		TreeItem<String> ballisticItems = new TreeItem<>("Ballistic");
		TreeItem<String> antiPersonnelItems = new TreeItem<>("AntiPersonnel");
		TreeItem<String> meleeItems = new TreeItem<>("Melee");
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
				weaponList = TreeViewBuilder.getItemList(getComponentFullPath());
				try {
					for (int i = 0; i < weaponList.size(); i++) {
						String category = weaponList.get(i).get("Category").toString();
						TreeItem<String> thisItem;
						switch (category.toLowerCase()) {
						case "missile":
							thisItem = TreeViewBuilder.getTreeViewBranch(category,
									(JSONObject) weaponList.get(i).get("Description"));
							missileItems.getChildren().add(thisItem);
							break;
						case "energy":
							thisItem = TreeViewBuilder.getTreeViewBranch(category,
									(JSONObject) weaponList.get(i).get("Description"));
							energyItems.getChildren().add(thisItem);
							break;
						case "ballistic":
							thisItem = TreeViewBuilder.getTreeViewBranch(category,
									(JSONObject) weaponList.get(i).get("Description"));
							ballisticItems.getChildren().add(thisItem);
							break;
						case "antipersonnel":
							thisItem = TreeViewBuilder.getTreeViewBranch(category,
									(JSONObject) weaponList.get(i).get("Description"));
							antiPersonnelItems.getChildren().add(thisItem);
							break;
						case "melee":
							thisItem = TreeViewBuilder.getTreeViewBranch(category,
									(JSONObject) weaponList.get(i).get("Description"));
							meleeItems.getChildren().add(thisItem);
							break;
						case "not set":
							break;
						default:
							break;
						}
					}
					rootItem.getChildren().addAll(energyItems, missileItems, ballisticItems, antiPersonnelItems,
							meleeItems);
					this.weaponTreeView.setRoot(rootItem);
					this.weaponTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (NullPointerException npe) {
			System.out.println("[setWeaponTreeView]: No directory selected");
		}
	}

	@FXML
	private void setShopsTreeView() throws NullPointerException {
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
			}
		} catch (NullPointerException npe) {
			System.out.println("[setShopsTreeView]: No directory selected");
		}
	}

	/**
	 * 
	 * @throws NullPointerException
	 */
	@FXML
	private void setHeatsinksTreeView() throws NullPointerException {
		ArrayList<JSONObject> heatsinksList;
		TreeItem<String> rootItem = new TreeItem<>("Heat Management");
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
				heatsinksList = TreeViewBuilder.getItemList(getComponentFullPath());
				try {
					for (int i = 0; i < heatsinksList.size(); i++) {
						TreeItem<String> thisItem;
						thisItem = TreeViewBuilder.getTreeViewBranch("heatsinks",
								(JSONObject) heatsinksList.get(i).get("Description"));
						rootItem.getChildren().add(thisItem);
					}
					this.heatsinksTreeView.setRoot(rootItem);
					this.heatsinksTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (NullPointerException npe) {
			System.out.println("[setHeatsinksTreeView]: No directory selected");
		}
	}

	@FXML
	private void setUpgradesTreeView() throws NullPointerException {
		ArrayList<JSONObject> upgradesList;
		TreeItem<String> rootItem = new TreeItem<>("Upgrade Items");
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
				File subDir = new File(getComponentFullPath());
//				try {
//					FileSystem fs = FileSystems.getDefault();
//					Path rootPath = fs.getPath(getComponentFullPath());
//					Files.walkFileTree(rootPath, visitor)
//					
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			// TODO
		} catch (NullPointerException npe) {
			System.out.println("[setUpgradesTreeView]: No directory selected");
		}
	}

	@FXML
	private void setMechsTreeView() throws NullPointerException {
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
			}
			// TODO
		} catch (NullPointerException npe) {
			System.out.println("[setMechsTreeView]: No directory selected");
		}
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
