package com.battletech.modder;

import java.io.IOException;

import com.battletech.modder.controller.CategoryOverviewController;
import com.battletech.modder.controller.RootLayoutController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BTModderMain extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	public BTModderMain() {
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Battletech Modder");
		// Set the application icon (for dev).
		// this.primaryStage.getIcons().add(new
		// Image("file:resources/images/AddressApp.png"));

		initRootLayout();
		showCategoryOverview();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(BTModderMain.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout, 950, 600);
			primaryStage.setScene(scene);
			// primaryStage.setResizable(false);

			// Give the controller access to the main app.
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// // Try to load last opened directory.
		// File file = getBTFilePath();
		// if (file != null) {
		// loadBTDataDir();
		// }
	}

	public void showCategoryOverview() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(BTModderMain.class.getResource("view/CategoryOverview.fxml"));
			AnchorPane categoryOverview = (AnchorPane) loader.load();

			// Set person overview into the center of root layout.
			rootLayout.setCenter(categoryOverview);

			// Give the controller access to the main app.
			CategoryOverviewController controller = loader.getController();
			controller.setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
