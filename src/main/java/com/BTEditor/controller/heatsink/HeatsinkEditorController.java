package com.BTEditor.controller.heatsink;

import com.BTEditor.Main;
import com.BTEditor.controller.Tag.TagEditorController;
import com.BTEditor.controller.main.MainController;
import com.BTEditor.controller.main.TableViewContextMenuHelper;
import com.BTEditor.controller.prefs.HeatsinkTablePrefs;
import com.BTEditor.model.enums.HeatsinkSubType;
import com.BTEditor.model.enums.HeatsinkType;
import com.BTEditor.model.heatsink.Heatsink;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

//import com.BTEditor.util.TableOps;

//import com.BTEditor.model.enums.HeatsinkCategory;
//import com.BTEditor.model.enums.HeatsinkSubType;

public class HeatsinkEditorController {
  public HeatsinkCollection heatsinkCollection;

  @FXML
  private HeatsinkTablePrefs heatsinkTablePrefs;
  @FXML
  private ComboBox<String> filterComboBox;
  @FXML
  private CheckBox toggleStock;
  @FXML
  private CheckBox toggleBatch;
  @FXML
  private ListView<String> filterListBox;

  @FXML
  private TableView<Heatsink> heatsinkTable;
  @FXML
  private TableColumn<Heatsink, String> h_colFilePath;
  @FXML
  private TableColumn<Heatsink, String> h_colFileName;
  @FXML
  private TableColumn<Heatsink, Integer> h_colDissCap;
  @FXML
  private TableColumn<Heatsink, Integer> h_colCost;
  @FXML
  private TableColumn<Heatsink, Integer> h_colRarity;
  @FXML
  private TableColumn<Heatsink, Boolean> h_colPurchasable;
  @FXML
  private TableColumn<Heatsink, String> h_colModel;
  @FXML
  private TableColumn<Heatsink, String> h_colId;
  @FXML
  private TableColumn<Heatsink, String> h_colDetails;
  @FXML
  private TableColumn<Heatsink, String> h_colIcon;
  @FXML
  private TableColumn<Heatsink, String> h_colName;
  @FXML
  private TableColumn<Heatsink, String> h_colMfr;

  @FXML
  private TableColumn<Heatsink, String> h_colBonusA;
  @FXML
  private TableColumn<Heatsink, String> h_colBonusB;
  @FXML
  private TableColumn<Heatsink, String> h_colComponentType;
  @FXML
  private TableColumn<Heatsink, String> h_colComponentSubType;
  @FXML
  private TableColumn<Heatsink, String> h_colPrefabId;
  @FXML
  private TableColumn<Heatsink, Integer> h_colBattleValue;
  @FXML
  private TableColumn<Heatsink, Integer> h_colInvSize;
  @FXML
  private TableColumn<Heatsink, Integer> h_colTons;
  @FXML
  private TableColumn<Heatsink, String> h_colAllowedLocations;
  @FXML
  private TableColumn<Heatsink, String> h_colDisallowedLocations;
  @FXML
  private TableColumn<Heatsink, Boolean> h_colCriticalComponent;

  private MainController mainController;

  @FXML
  private void initialize() {
    filterComboBox.getItems().addAll("All", "Thermal Exchangers", "Thermal Banks", "Heatsinks");
    toggleStock.setOnAction(event -> populateTable());
    setCellValueFactories();
    setCellFactories();
  }

  public void postInitSetup(MainController mainController) {
    this.mainController = mainController;
//        tableColumnsFinal = Collections.unmodifiableList(new ArrayList<>(table.getColumns()));
    TableViewContextMenuHelper helper = new TableViewContextMenuHelper(heatsinkTable);
    this.heatsinkTablePrefs = new HeatsinkTablePrefs();
    setTablePrefs();
    setTableListeners();
    setTableContextMenu();
    populateTable();
    h_colFilePath.setStyle("-fx-text-overrun: center-ellipsis ");
  }

  private void setCellValueFactories() {
    for (TableColumn column : heatsinkTable.getColumns())
      column.setCellValueFactory(new PropertyValueFactory<>(column.getText()));
  }

  private void setCellFactories() {
//    colCategory.setCellFactory(TextFieldTableCell.forTableColumn());
//    colType.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colDissCap.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    h_colMfr.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colTons.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    h_colBonusA.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colBonusB.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colCost.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    h_colRarity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    h_colPurchasable.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    h_colModel.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colId.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colName.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colDetails.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colIcon.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colComponentType.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colComponentSubType.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colPrefabId.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colBattleValue.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    h_colInvSize.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    h_colAllowedLocations.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colDisallowedLocations.setCellFactory(TextFieldTableCell.forTableColumn());
    h_colCriticalComponent.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
  }

  private void setTablePrefs() {
    for (TableColumn tableColumn : heatsinkTable.getColumns()) {
      double prefWidth = getPrefs().getColWidth(tableColumn.getText());
      tableColumn.setPrefWidth(prefWidth);
      tableColumn.setVisible(getPrefs().getShowCol("show" + tableColumn.getText()));
    }
  }

  //  private void setTableListeners(){
//    TableOps.setHeatsinkTableListeners(heatsinkTable,getPrefs());
//  }
  private void setTableListeners() {
    for (TableColumn tableColumn : heatsinkTable.getColumns()) {

      // width listener
      tableColumn.widthProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
          getPrefs().setColWidth(tableColumn.getText() + "Width", newValue.intValue());
        }
      });

      // visibility listener
      tableColumn.visibleProperty().addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
          getPrefs().setShowCol("show" + tableColumn.getText(), newValue);
        }
      });
    }
  }

  private void setTableContextMenu() {
    heatsinkTable.setRowFactory(param -> {
      final TableRow<Heatsink> row = new TableRow<>();
      final ContextMenu contextMenu = new ContextMenu();

      MenuItem openFile = new MenuItem("Open File");
      openFile.setOnAction(event -> mainController.getHeatsinkList().openFile(row.getItem()));

      MenuItem openTagEditor = new MenuItem("Edit ComponentTags");
      openTagEditor.setOnAction(event -> {
        try {
          FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fx/TagEditor.fxml"));
          Parent root = loader.load();
          TagEditorController controller = loader.getController();
          controller.heatsinkSetup(row.getItem());
          Stage stage = new Stage();
          stage.initModality(Modality.APPLICATION_MODAL);
          stage.setScene(new Scene(root));
          stage.setTitle("Select Heatsink Tags");
          stage.showAndWait();
        } catch (Exception e) {
          e.printStackTrace();
        }
      });

      contextMenu.getItems().addAll(openFile, openTagEditor);
      // only display context menu for non-null items:
      row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then(contextMenu).otherwise((ContextMenu) null));
      return row;
    });
  }

  private void clearTable(TableView<?> tableView) {
    tableView.getItems().clear();
  }

  public void populateTable() {
//    clearTable(heatsinkTable);
    this.mainController.getHeatsinkList().filter(filterComboBox.getValue());
    ObservableList<Heatsink> observableList = FXCollections.observableList(mainController.getHeatsinkList().getHeatsinkSubList());
    heatsinkTable.setItems(observableList);
  }

  public void filterTypeSelected(ActionEvent actionEvent) {
    filterListBox.getItems().clear();

    switch (filterComboBox.getValue()) {

      case "All":
        filterListBox.getItems().add("All");
        break;

      case "Thermal Exchangers":
        for (HeatsinkType type : HeatsinkType.values())
          filterListBox.getItems().add(type.name());
        break;

      case "Thermal Banks":
        for (HeatsinkSubType subType : HeatsinkSubType.values())
          filterListBox.getItems().add(subType.name());
        break;

      case "Heatsinks":
        for (HeatsinkSubType subType : HeatsinkSubType.values())
          filterListBox.getItems().add(subType.name());
        break;
    }
  }

  public void subFilterClicked(MouseEvent mouseEvent) {
    populateTable();
  }

  public void strCellCommit(TableColumn.CellEditEvent<Heatsink, String> cellEditEvent) {
    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    heatsinkTable.refresh();
  }

  public void intCellCommit(TableColumn.CellEditEvent<Heatsink, Integer> cellEditEvent) {
    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    heatsinkTable.refresh();
  }

  public void dblCellCommit(TableColumn.CellEditEvent<Heatsink, Double> cellEditEvent) {
    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    heatsinkTable.refresh();
  }

  public void boolCellCommit(TableColumn.CellEditEvent<Heatsink, Boolean> cellEditEvent) {
    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    heatsinkTable.refresh();
  }

  public TableView<Heatsink> getTable() {
    return heatsinkTable;
  }

  private HeatsinkTablePrefs getPrefs() {
    return heatsinkTablePrefs;
  }
}
