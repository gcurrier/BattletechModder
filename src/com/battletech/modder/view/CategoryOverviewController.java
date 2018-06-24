package com.battletech.modder.view;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.battletech.modder.BTModderMain;
import com.battletech.modder.control.utils.TreeViewBuilder;
import com.battletech.modder.model.Description;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class CategoryOverviewController {

	// Components belonging to the Parent Tab Pane
	@FXML
	private TabPane														tabPane;

	// Weapons Tab components and children
	@FXML
	private Tab																weaponTab;
	@FXML
	private SplitPane													weaponSplitPane;
	@FXML
	private AnchorPane												weaponsLHSAnchorPane;
	@FXML
	private AnchorPane												weaponsRHSAnchorPane;
	@FXML
	private TableView<Description>						weaponDescTable;
	@FXML
	private TextArea													weaponDetailText;
	@FXML
	private TreeView<String>									weaponTreeView;
	@FXML
	private Label															weaponsTabLabel;
	@FXML
	private Button														weaponEdit;
	@FXML
	private Button														weaponSave;
	@FXML
	private Button														weaponCancel;
	@FXML
	private TableColumn<Description, String>	weaponCategoryCol;
	@FXML
	private TableColumn<Description, String>	weaponDetailCol;

	// Heatsinks Tab components and children
	// @FXML
	// private TreeTableView<Heatsink> heatsinksTreeTableView;
	@FXML
	private Tab																heatsinksTab;
	@FXML
	private SplitPane													heatsinksSplitPane;
	@FXML
	private AnchorPane												heatsinksLHSAnchorPane;
	@FXML
	private TreeView<String>									heatsinksTreeView;
	@FXML
	private Label															heatsinksTabLabel;

	// Upgrades Tab components and children
	@FXML
	private Tab																upgradesTab;
	@FXML
	private SplitPane													upgradesSplitPane;
	@FXML
	private AnchorPane												upgradesLHSAnchorPane;
	@FXML
	private TreeView<String>									upgradesTreeView;
	@FXML
	private Label															upgradesTabLabel;

	// Shops Tab components and children
	@FXML
	private Tab																shopsTab;
	@FXML
	private SplitPane													shopsSplitPane;
	@FXML
	private AnchorPane												shopsLHSAnchorPane;
	@FXML
	private TreeView<String>									shopsTreeView;
	@FXML
	private Label															shopsTabLabel;

	// Mech Tab components and children
	@FXML
	private Tab																mechTab;
	@FXML
	private SplitPane													mechSplitPane;
	@FXML
	private AnchorPane												mechLHSAnchorPane;
	@FXML
	private TreeView<String>									mechTreeView;
	@FXML
	private Label															mechsTabLabel;

	@FXML
	private Button														editBtn;
	@FXML
	private Button														saveBtn;
	@FXML
	private Button														cancelBtn;

	private ObservableList<Tab>								allTabs;
	private Node															selectedTabContent;
	private BTModderMain											btModder;
	/**
	 * Observable list of Descriptions
	 */
	public static ObservableList<Description>				descriptionListData	= FXCollections.observableArrayList();

	public static String											activeTabText;
	public static String											componentFullPath;
	public static int													selectedTabIdx			= 0;

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
	 *          the selectedDirectory to set
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

	public ObservableList<Description> getDescriptionListData() {
		return descriptionListData;
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
	 * Populates the Update tab TreeView based on the file list from the
	 * ...BATTLETECH/BattleTech_Data/StreamingAssets/data/weapons directory
	 * 
	 * @throws NullPointerException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
							thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) weaponList.get(i).get("Description"));
							missileItems.getChildren().add(thisItem);
							break;
						case "energy":
							thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) weaponList.get(i).get("Description"));
							energyItems.getChildren().add(thisItem);
							break;
						case "ballistic":
							thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) weaponList.get(i).get("Description"));
							ballisticItems.getChildren().add(thisItem);
							break;
						case "antipersonnel":
							thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) weaponList.get(i).get("Description"));
							antiPersonnelItems.getChildren().add(thisItem);
							break;
						case "melee":
							thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) weaponList.get(i).get("Description"));
							meleeItems.getChildren().add(thisItem);
							// missileItems.set
							break;
						case "not set":
							break;
						default:
							break;
						}
					}
					rootItem.getChildren().addAll(energyItems, missileItems, ballisticItems, antiPersonnelItems, meleeItems);
					rootItem.setExpanded(true);
					this.weaponTreeView.setRoot(rootItem);
					this.weaponTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
					this.weaponTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
						/**
						 * Retrieve selected weapon data when a leaf item in the weapon tree view is
						 * clicked
						 * 
						 * @param item
						 */
						@Override
						public void changed(ObservableValue obs, Object oldVal, Object newVal) {
							TreeItem<String> selectedItem = (TreeItem<String>) obs.getValue();
							boolean hasParent = selectedItem.getParent() != null;
							boolean hasChildren = selectedItem.getChildren().isEmpty() ? false : true;
							String fileFullPath = getComponentFullPath() + "\\" + selectedItem.getValue();

							if (hasParent && !hasChildren) {
								JSONObject weaponData = WeaponDataController.getWeaponData(fileFullPath);
								try {
									JSONObject description = (JSONObject) weaponData.get("Description");
									JSONArray descArr = description.names();
									for (int i = 0; i < descArr.length(); i++) {
										String descKey = descArr.getString(i);
										String descVal = description.getString(descKey);
										if (descKey.equals("Details")) {
											weaponDetailText.setText(descVal);
											weaponDetailText.setWrapText(true);
											weaponDetailText.setEditable(false);
										} else if(descKey.equals("Name")) {
											weaponsTabLabel.setText(descVal);
										} else {
											descriptionListData.add(new Description(descKey.toString(), descVal.toString()));
										}
										System.out.println(descKey + ": " + descVal);
									}
									weaponCategoryCol.setCellValueFactory(new PropertyValueFactory<Description, String>("Category"));
									weaponDetailCol.setCellValueFactory(new PropertyValueFactory<Description, String>("Detail"));
									weaponDescTable.setItems(getDescriptionListData());
								} catch (JSONException e) {
									e.printStackTrace();
								}
								System.out.println("retrieved");
							}
						}
					});
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
	 * Populates the Update tab TreeView based on the file list from the
	 * ...BATTLETECH/BattleTech_Data/StreamingAssets/data/heatsinks directory
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
						thisItem = TreeViewBuilder.getTreeViewBranch("heatsinks", (JSONObject) heatsinksList.get(i).get("Description"));
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

	/**
	 * Populates the Update tab TreeView based on the file list from the
	 * ...BATTLETECH/BattleTech_Data/StreamingAssets/data/upgrades directory
	 * 
	 * @throws NullPointerException
	 */
	@SuppressWarnings("unchecked")
	@FXML
	private void setUpgradesTreeView() throws NullPointerException {
		Map<String, String> subDirList = new HashMap<String, String>();
		TreeItem<String> rootItem = new TreeItem<>("Upgrade Items");
		TreeItem<String> gyrosItems = new TreeItem<>("Gyros");
		TreeItem<String> actuatorsItems = new TreeItem<>("Actuators");
		TreeItem<String> cockpitModItems = new TreeItem<>("Cockpit Mods");
		TreeItem<String> ttsItems = new TreeItem<>("Target Tracking");
		try {
			if (getBtModder().rootController.selectedDirectory.exists()) {
				System.out.println(getComponentFullPath());
				try {
					FileSystem fs = FileSystems.getDefault();
					Path rootPath = fs.getPath(getComponentFullPath());
					Files.walkFileTree(rootPath, EnumSet.of(FileVisitOption.FOLLOW_LINKS), 1, new SimpleFileVisitor<Path>() {
						@Override
						public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
							String filePath = file.getParent().toAbsolutePath().toString();
							String fileName = file.getFileName().toString();
							if (attrs.isDirectory()) {
								subDirList.put(fileName, filePath + "\\" + fileName);
							}
							return FileVisitResult.CONTINUE;
						}
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			for (Map.Entry<String, String> dir : subDirList.entrySet()) {
				// TreeItem<String> branchItem = new TreeItem<String>(dir.getKey());
				System.out.println("key: " + dir.getKey() + "\n" + "value: " + dir.getValue());
				ArrayList<JSONObject> thisFileList = null;
				thisFileList = TreeViewBuilder.getItemList(dir.getValue());
				try {
					for (int i = 0; i < thisFileList.size(); i++) {
						String category = dir.getKey().toLowerCase();
						TreeItem<String> thisItem;
						if (((JSONObject) thisFileList.get(i).get("Description")).get("Name") != null) {
							switch (category) {
							case "gyros":
								thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) thisFileList.get(i).get("Description"));
								gyrosItems.getChildren().add(thisItem);
								break;
							case "actuators":
								thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) thisFileList.get(i).get("Description"));
								actuatorsItems.getChildren().add(thisItem);
								break;
							case "cockpitmods":
								thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) thisFileList.get(i).get("Description"));
								cockpitModItems.getChildren().add(thisItem);
								break;
							case "targettrackingsystem":
								thisItem = TreeViewBuilder.getTreeViewBranch(category, (JSONObject) thisFileList.get(i).get("Description"));
								ttsItems.getChildren().add(thisItem);
								break;
							case "not set":
								break;
							default:
								break;
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			rootItem.getChildren().addAll(gyrosItems, actuatorsItems, cockpitModItems, ttsItems);
			this.upgradesTreeView.setRoot(rootItem);
			this.upgradesTreeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		} catch (NullPointerException npe) {
			System.out.println("[setUpgradesTreeView]: No directory selected");
		}
	}

	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		if (attr.isSymbolicLink()) {
			System.out.format("Symbolic link: %s ", file);
		} else if (attr.isRegularFile()) {
			System.out.format("Regular file: %s ", file);
		} else if (attr.isDirectory()) {
			System.out.format("Regular directory: %s ", file);
		} else {
			System.out.format("Other: %s ", file);
		}
		System.out.println("(" + attr.size() + "bytes)");
		return FileVisitResult.CONTINUE;
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
	 *          the btModder to set
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
	 *          the activeTabText to set
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
