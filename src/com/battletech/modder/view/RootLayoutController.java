package com.battletech.modder.view;

import java.io.File;
import java.util.Enumeration;
import java.util.Properties;

import com.battletech.modder.BTModderMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
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
	 * @param btModder the btModder to set
	 */
	public void setBtModder(BTModderMain btModder) {
		this.btModder = btModder;
	}

	/**
	 * Opens a FileChooser to let the user select an address book to load.
	 */
	@FXML
	private void handleOpenDirectory(ActionEvent e) {

		DirectoryChooser dirChooser = new DirectoryChooser();
		//Properties props = System.getProperties();
		//props.list(System.out);
		dirChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		File selectedDirectory = dirChooser.showDialog(getBtModder().getPrimaryStage());

		if (selectedDirectory == null) {
			labelConfigDir.setText("No Directory selected");
		} else {
			labelConfigDir.setText(selectedDirectory.getAbsolutePath());
		}
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
		alert.setTitle("Battletech Modder Tool");
		alert.setHeaderText("About");
		alert.setContentText("Author: Glen Currier\nBuildDate: TBD\nWebsite: forthcoming");
		alert.showAndWait();
	}
}
