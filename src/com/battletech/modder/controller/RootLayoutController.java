package com.battletech.modder.controller;

import com.battletech.modder.BTModderMain;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Controller for the root layout pane. Root layout consists of a BorderPane
 * with a menu bar
 * 
 * @author jinx3y
 *
 */
public class RootLayoutController {

	@SuppressWarnings("unused")
	private BTModderMain btModderMain;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param btModderMain
	 */
	public void setMainApp(BTModderMain btModderMain) {
		this.btModderMain = btModderMain;
	}

	@FXML
	private void handleOpenDirectory() {
		// TODO
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
