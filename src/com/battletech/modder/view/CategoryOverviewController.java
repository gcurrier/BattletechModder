package com.battletech.modder.view;

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
	private Label componentsTabLabel;

	private ObservableList<Tab> allTabs;

	private BTModderMain btModder;
	
	public String activeTabText;

	/**
	 * Empty constructor. The constructor is called before the initialize() method.
	 */
	public CategoryOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		setAllTabs(tabPane.getTabs());
		//set the active tab to be the first one (should be Weapons tab)
		tabPane.getSelectionModel().select(0);
		setActiveTabText("Weapons");
		//TODO 
		mechsTabLabel.setText("Mechs Data Display");
		shopsTabLabel.setText("Shops Data Display");
		componentsTabLabel.setText("Components Data Display");
		weaponsTabLabel.setText("Weapons Data Display");
		//Change the display label at the bottom of the window whenever a tab is selected AFTER a directory has been selected.
		tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
			   @Override
			   public void changed(ObservableValue<? extends Tab> ov, Tab tabOld, Tab tabNew) {
				   setActiveTabText(tabNew.getText());
				   getBtModder().rootController.setLabelConfigDirText(getActiveTabText());
				   System.out.println("Tab Selection changed to " + getActiveTabText());
				   //TODO Open directory associated with tab, parse all files into a single ArrayList and display in LHS tree view. Clicking a tree view item will display data in RHS gridview.
			   }
			});
	}
	
	@FXML
	private void setMechsTab() {
		
	}

	@FXML
	private void setShopsTab() {

	}
	
	@FXML
	private void setComponentsTab() {

	}
	
	@FXML
	private void setWeaponsTab() {
		
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
	 * @param btModder the btModder to set
	 */
	public void setBtModder(BTModderMain btModder) {
		this.btModder = btModder;
	}

	/**
	 * @return the activeTab text name
	 */
	public String getActiveTabText() {
		return this.activeTabText.toLowerCase();
	}
	
	/**
	 * @param activeTabText the activeTabText to set
	 */
	public void setActiveTabText(String activeTabText) {
		this.activeTabText = activeTabText;
	}

	/**
	 * @return the activeTab
	 */
	public Tab getActiveTab() {
		Tab activeTab = tabPane.getSelectionModel().getSelectedItem();
		return activeTab;
	}
}
