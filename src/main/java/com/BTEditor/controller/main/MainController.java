package com.BTEditor.controller.main;

import com.BTEditor.Main;
import com.BTEditor.controller.heatsink.HeatsinkCollection;
import com.BTEditor.controller.heatsink.HeatsinkEditorController;
import com.BTEditor.controller.prefs.AppPrefs;
import com.BTEditor.controller.weapon.WeaponCollection;
import com.BTEditor.controller.weapon.WeaponEditorController;
import com.BTEditor.model.common.ItemCollection;
import com.BTEditor.model.enums.ItemFolders;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainController {
  @FXML
  public TabPane allTabsPane;
  @FXML
  public Tab weaponTab;
  @FXML
  public AnchorPane weaponEditor;
  @FXML
  private WeaponCollection weaponArrayList;
  @FXML
  public Tab heatsinkTab;
  @FXML
  public AnchorPane heatsinkEditor;
  @FXML
  private HeatsinkCollection heatsinkArrayList;
  @FXML
  private AppPrefs prefs;
  @FXML
  private MenuItem fileOpen;
  @FXML
  private MenuItem fileExit;
  @FXML
  private MenuItem editSaveCurrent;
  @FXML
  private MenuItem editBackup;
  @FXML
  private MenuItem editRestore;
  @FXML
  private Menu viewColumns;
  @FXML
  private MenuItem helpAbout;
  @FXML
  private Label workingDirDisplay;

  @FXML
  private Stage mainStage;

  @FXML
  private WeaponEditorController weaponEditorController;
  @FXML
  private HeatsinkEditorController heatsinkEditorController;

//TODO  @FXML private WeaponEditorController weaponEditorController;

  @FXML
  private void initialize() {
    prefs = new AppPrefs();
    //TODO
    weaponArrayList = new WeaponCollection(prefs.getWorkingDir());
    weaponEditorController.postInitSetup(this);

    heatsinkArrayList = new HeatsinkCollection(prefs.getWorkingDir());
    heatsinkEditorController.postInitSetup(this);

    workingDirDisplay.setText(prefs.getWorkingDir());
//    populateViewColumnsMenu();
  }

  @FXML
  private void fileOpen(ActionEvent event) {
    File initDir = new File(prefs.getWorkingDir());
    if (!initDir.exists()) {
      prefs.setWorkingDir("C://");
      initDir = new File(prefs.getWorkingDir());
    }

    DirectoryChooser dChooser = new DirectoryChooser();
    dChooser.setTitle("Select Directory");
    dChooser.setInitialDirectory(initDir);
    File dir = dChooser.showDialog(mainStage);
    if (dir != null) {
      prefs.setWorkingDir(dir.getAbsolutePath());
      workingDirDisplay.setText(prefs.getWorkingDir());
      String workingPath = prefs.getWorkingDir()+ "\\";
      //TODO initialize the tables of each tab displayed in the gui window
      //TODO get list of available tabs and populate based on the tab id (should reflect the folder name) found while skipping the rest of the folders available
//      weaponArrayList = new WeaponCollection(dir.getAbsolutePath() + "\\weapon");
//      weaponEditorController.populateTable();
      for(ItemFolders item: ItemFolders.values()) {
        switch (item) {
          case weapon:
            weaponEditorController.populateTable();
//            ItemCollection weaponsCollection = new ItemCollection(workingPath + item.name());
            break;
          case heatsinks:
            heatsinkEditorController.populateTable();
//            ItemCollection heatsinkCollection = new ItemCollection(workingPath + item.name() );
            break;
//          case shops:
//            break;
//          case starsystem:
//            break;
//          case upgrades:
//            break;
        }
      }
    }
  }

  @FXML
  private void fileExit(ActionEvent event) {
    Platform.exit();
  }

  @FXML
  private void editSaveCurrent(ActionEvent event) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Save current changes?", ButtonType.APPLY, ButtonType.CANCEL);
    alert.showAndWait();

    if (alert.getResult() == ButtonType.APPLY) {
      weaponArrayList.write();
    }
  }

  @FXML
  private void editBackup(ActionEvent event) {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm").format(new Date());
    String sampleFileName = "BTEditor-backup-" + timeStamp;

    File initDir = new File(prefs.getBackupDir());
    if (!initDir.exists()) {
      prefs.setBackupDir("C://");
      initDir = new File(prefs.getBackupDir());
    }

    FileChooser fChooser = new FileChooser();
    fChooser.setTitle("Select Save Location");
    fChooser.setInitialDirectory(initDir);
    fChooser.setInitialFileName(sampleFileName);
    fChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json", "*.json"));
    File file = fChooser.showSaveDialog(mainStage);
    if (file != null) {
      prefs.setBackupDir(file.getParent());
      //TODO list.backup(file);
    }
  }

  @FXML
  private void editRestore(ActionEvent event) {
    File initDir = new File(prefs.getBackupDir());
    if (!initDir.exists()) {
      prefs.setBackupDir("C://");
      initDir = new File(prefs.getBackupDir());
    }

    FileChooser fChooser = new FileChooser();
    fChooser.setTitle("Select Save Location");
    fChooser.setInitialDirectory(initDir);
    fChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json", "*.json"));
    File file = fChooser.showOpenDialog(mainStage);

    if (file != null) {
      prefs.setBackupDir(file.getParent());
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Restore data from backup?", ButtonType.YES, ButtonType.NO);
      alert.showAndWait();

      if (alert.getResult() == ButtonType.YES) {
      }
      //TODO list.restore(file, prefs.getWorkingDir());
    }
    //TODO
//    list = new WeaponCollection(prefs.getWorkingDir());
//    weaponEditorController.populateTable();
  }

  @FXML
  private void helpAbout(ActionEvent event) {
    try {
      Parent aboutRoot = new FXMLLoader(Main.class.getResource("/fx/About.fxml")).load();
      Stage stage = new Stage();
      stage.setScene(new Scene(aboutRoot));
      stage.setTitle("About");
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //TODO
  private void populateViewColumnsMenu() {
    for (TableColumn column : weaponEditorController.getTable().getColumns()) {
      CheckBox cb = new CheckBox(column.getText());
      cb.setSelected(column.isVisible());
      cb.setTextFill(Color.BLACK);
      cb.setOnAction(event -> {
        column.setVisible(cb.isSelected());
      });
      CustomMenuItem cmi = new CustomMenuItem(cb);
      cmi.setHideOnClick(false);
      viewColumns.getItems().add(cmi);
    }
  }

  public AppPrefs getPrefs() {
    return prefs;
  }

  public WeaponCollection getWeaponList() {
    return weaponArrayList;
  }

  public HeatsinkCollection getHeatsinkList() {
    return heatsinkArrayList;
  }

//  public WeaponCollection setWeaponList(ArrayList<Weapon> weaponArrayList) {
//    this.weaponArrayList = weaponArrayList;
//  }
}
