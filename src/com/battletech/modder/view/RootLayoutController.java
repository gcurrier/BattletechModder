package com.battletech.modder.view;

import java.io.File;
import java.util.Properties;

import com.battletech.modder.BTModderMain;
import com.battletech.modder.control.utils.SimpleLogger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.stage.DirectoryChooser;

/**
 * Controller for the root layout pane. Root layout consists of a BorderPane
 * with a menu bar
 * 
 * @author jinx3y
 *
 */
public class RootLayoutController {

	@FXML
	private Label labelConfigDir;
	
	private BTModderMain btModder;
	
	public File selectedDirectory;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param btModder
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
	 * @return the selectedDirectory
	 */
	public File getSelectedDirectory() {
		return selectedDirectory;
	}

	/**
	 * @param selectedDirectory
	 *            the selectedDirectory to set
	 */
	public void setSelectedDirectory(File selectedDirectory) throws NullPointerException {
		try {
			this.selectedDirectory = selectedDirectory;
		} catch (NullPointerException npe) {
			System.out.println("No Directory Selected");
		}
	}

	/**
	 * @return the labelConfigDir
	 */
	public Label getLabelConfigDir() {
		return labelConfigDir;
	}

	/**
	 * @param labelConfigDir
	 *            the labelConfigDir to set
	 */
	public void setLabelConfigDirText(String absolutePath) {
		// this.labelConfigDir.setText("");
		this.labelConfigDir.setText(absolutePath);
	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpenDirectory(ActionEvent e) throws NullPointerException {
		DirectoryChooser dirChooser = new DirectoryChooser();
		Properties props = System.getProperties();
		props.list(System.out);
		dirChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		// String selectedTabName = "";
		try {
			setSelectedDirectory(dirChooser.showDialog(getBtModder().getPrimaryStage()));
			setLabelConfigDirText(getSelectedDirectory().getAbsolutePath() + "\\");
		} catch (NullPointerException npe) {
			setLabelConfigDirText("No Directory selected");
			System.out.println("No Directory Selected");
		}

//		if (getSelectedDirectory() != null) {			
//			getBtModder().categoryController.setInitialView();
			// TODO original directory needs to be copied to app folder or to
			// System.property location. /BattletechModderBackups...
			// TODO from here the subdirectory needs to be opened and all files therein
			// parsed into an array.
			// TODO pass parsed data back to categoryController and set the LHS tree view.
			// TODO clicking on element in tree view opens up the data and displays it for
			// edit in the RHS pane
//		}
	}

	@FXML
	private void handleExitApp() {
		System.exit(0);
	}

	@FXML
	private void handleWpnDmgChart() {
		// TODO
	}

	@FXML
	private void handleWpnRngChart() {
		// TODO
	}

	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Battletech Modder Tool (version 0.2.1a)");
		alert.setHeaderText("About");
		alert.setContentText("Author: Glen Currier\nBuildDate: TBD\nWebsite: forthcoming");
		alert.showAndWait();
	}
}
