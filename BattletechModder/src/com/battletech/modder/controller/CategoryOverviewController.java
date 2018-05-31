package com.battletech.modder.controller;

import com.battletech.modder.BTModderMain;

import javafx.fxml.FXML;

public class CategoryOverviewController {
	private BTModderMain btModderMain;
	
	/**
     * Empty constructor.
     * The constructor is called before the initialize() method.
     */
	public CategoryOverviewController() {}
	
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {}
	
    /**
     * Called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(BTModderMain btModderMain) {
        this.btModderMain = btModderMain;
        
        //TODO add category display
    }
}
