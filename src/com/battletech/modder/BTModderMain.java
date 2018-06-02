package com.battletech.modder;

import java.io.IOException;

import com.battletech.modder.view.CategoryOverviewController;
import com.battletech.modder.view.RootLayoutController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BTModderMain extends Application {

	private Stage primaryStage;
	public BorderPane rootLayout;
	public AnchorPane categoryLayout;
	public String tabName;
	public CategoryOverviewController categoryController;
	public RootLayoutController rootController;

	public BTModderMain() {
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Battletech Modder");
		this.primaryStage.getIcons().add(new Image("file:resources/BattletechModder.png"));
		// Set the application icon (for dev).
		// this.primaryStage.getIcons().add(new
		// Image("file:resources/images/AddressApp.png"));

		initRootLayout();
		showCategoryOverview();
	}

	/**
	 * @return the categoryController
	 */
	public CategoryOverviewController getCategoryController() {
		return categoryController;
	}

	/**
	 * @param categoryController the categoryController to set
	 */
	public void setCategoryController(CategoryOverviewController categoryController) {
		this.categoryController = categoryController;
	}

	/**
	 * @return the rootController
	 */
	public RootLayoutController getRootController() {
		return rootController;
	}

	/**
	 * @param rootController the rootController to set
	 */
	public void setRootController(RootLayoutController rootController) {
		this.rootController = rootController;
	}

	/**
	 * @return the rootLayout
	 */
	public BorderPane getRootLayout() {
		return rootLayout;
	}

	/**
	 * @param rootLayout
	 *            the rootLayout to set
	 */
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}

	/**
	 * @return the categoryLayout
	 */
	public AnchorPane getCategoryLayout() {
		return categoryLayout;
	}

	/**
	 * @param categoryLayout
	 *            the categoryLayout to set
	 */
	public void setCategoryLayout(AnchorPane categoryLayout) {
		this.categoryLayout = categoryLayout;
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(BTModderMain.class.getResource("view/RootLayout.fxml"));
			setRootLayout((BorderPane) loader.load());
			// Show the scene containing the root layout.
			Scene scene = new Scene(getRootLayout(), 950, 600);
			primaryStage.setScene(scene);
			// Give the RootLayoutController access to the main app.
			setRootController(loader.getController());
			getRootController().setMainApp(this);

			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Show the Category Overview inside the Root Layout
	 */
	public void showCategoryOverview() {
		try {
			// Load category overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(BTModderMain.class.getResource("view/CategoryOverview.fxml"));
			setCategoryLayout((AnchorPane) loader.load());
			// Set category overview into the center of root layout.
			rootLayout.setCenter(getCategoryLayout());
			// Give the CategoryOverviewController access to the main app.
			setCategoryController(loader.getController());
			getCategoryController().setMainApp(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
