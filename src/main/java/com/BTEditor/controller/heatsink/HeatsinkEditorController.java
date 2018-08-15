package com.BTEditor.controller.heatsink;

import com.BTEditor.controller.main.MainController;
import com.BTEditor.controller.main.TableViewContextMenuHelper;
import com.BTEditor.controller.prefs.HeatsinkTablePrefs;
import com.BTEditor.model.enums.HeatsinkSubType;
import com.BTEditor.model.enums.HeatsinkType;
import com.BTEditor.model.heatsink.Heatsink;
//import com.BTEditor.util.TableOps;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

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
  private TableColumn<Heatsink, String> colFilePath;
  @FXML
  private TableColumn<Heatsink, String> colFileName;
  @FXML
  private TableColumn<Heatsink, String> colName;
  @FXML
  private TableColumn<Heatsink, Integer> colDissCap;
  @FXML
  private TableColumn<Heatsink, String> colType;
  @FXML
  private TableColumn<Heatsink, String> colMfr;
  @FXML
  private TableColumn<Heatsink, Double> colTons;
  @FXML
  private TableColumn<Heatsink, String> colBonusA;
  @FXML
  private TableColumn<Heatsink, String> colBonusB;
  @FXML
  private TableColumn<Heatsink, Integer> colCost;
  @FXML
  private TableColumn<Heatsink, Integer> colRarity;
  @FXML
  private TableColumn<Heatsink, Boolean> colPurchasable;
  @FXML
  private TableColumn<Heatsink, String> colModel;
  @FXML
  private TableColumn<Heatsink, String> colId;
  @FXML
  private TableColumn<Heatsink, String> colDetails;
  @FXML
  private TableColumn<Heatsink, String> colIcon;
  @FXML
  private TableColumn<Heatsink, String> colComponentType;
  @FXML
  private TableColumn<Heatsink, String> colComponentSubType;
  @FXML
  private TableColumn<Heatsink, String> colPrefabId;
  @FXML
  private TableColumn<Heatsink, Integer> colBattleValue;
  @FXML
  private TableColumn<Heatsink, Integer> colInvSize;
  @FXML
  private TableColumn<Heatsink, String> colAllowedLocations;
  @FXML
  private TableColumn<Heatsink, String> colDisallowedLocations;
  @FXML
  private TableColumn<Heatsink, Boolean> colCriticalComponent;

  private MainController mainController;

  @FXML
  private void initialize() {
    filterComboBox.getItems().addAll("All", "Type", "HeatsinkSubType");
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
    colFilePath.setStyle("-fx-text-overrun: center-ellipsis ");
  }

  private void setCellValueFactories() {
    for (TableColumn column : heatsinkTable.getColumns())
      column.setCellValueFactory(new PropertyValueFactory<>(column.getText()));
  }

  private void setCellFactories() {
    colName.setCellFactory(TextFieldTableCell.forTableColumn());
    colDissCap.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//    colType.setCellFactory(TextFieldTableCell.forTableColumn());
//    colMfr.setCellFactory(TextFieldTableCell.forTableColumn());
//    colTons.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    colBonusA.setCellFactory(TextFieldTableCell.forTableColumn());
    colBonusB.setCellFactory(TextFieldTableCell.forTableColumn());
//    colCost.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//    colRarity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
//    colPurchasable.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
//    colModel.setCellFactory(TextFieldTableCell.forTableColumn());
//    colId.setCellFactory(TextFieldTableCell.forTableColumn());
//    colDetails.setCellFactory(TextFieldTableCell.forTableColumn());
//    colIcon.setCellFactory(TextFieldTableCell.forTableColumn());
    colComponentType.setCellFactory(TextFieldTableCell.forTableColumn());
    colComponentSubType.setCellFactory(TextFieldTableCell.forTableColumn());
    colPrefabId.setCellFactory(TextFieldTableCell.forTableColumn());
    colBattleValue.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colInvSize.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colAllowedLocations.setCellFactory(TextFieldTableCell.forTableColumn());
    colDisallowedLocations.setCellFactory(TextFieldTableCell.forTableColumn());
    colCriticalComponent.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
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
//    heatsinkTable.setRowFactory(new Callback<TableView<Heatsink>, TableRow<Heatsink>>() {
//      @Override
//      public TableRow<Heatsink> call(TableView<Heatsink> param) {
//        final TableRow<Heatsink> row = new TableRow<>();
//        final ContextMenu contextMenu = new ContextMenu();
//
//        MenuItem openFile = new MenuItem("Open File");
//        openFile.setOnAction(event -> mainController.getHeatsinkList().openFile(row.getItem()));
//
//        MenuItem openTagEditor = new MenuItem("Edit ComponentTags");
//        openTagEditor.setOnAction(event -> {
//          try {
//            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fx/TagEditor.fxml"));
//            Parent root = loader.load();
//            TagEditorController controller = loader.getController();
//            controller.heatsinkSetup(row.getItem());
//            Stage stage = new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.setScene(new Scene(root));
//            stage.setTitle("Select Heatsink Tags");
//            stage.showAndWait();
//          } catch (Exception e) {
//            e.printStackTrace();
//          }
//        });
//
//        contextMenu.getItems().addAll(openFile, openTagEditor);
//        // only display context menu for non-null items:
//        row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then(contextMenu).otherwise((ContextMenu) null));
//        return row;
//      }
//    });
  }

  public void populateTable() {
//    this.mainController.getHeatsinkList()
//        .filter(
//            filterComboBox.getValue(),
//            filterListBox
//                .getSelectionModel()
//                .getSelectedItem(),
//            toggleStock.isSelected());
//    ObservableList<Heatsink> observableList = FXCollections.observableList(mainController.getHeatsinkList().getHeatsinkSubList());
//    heatsinkTable.setItems(observableList);
  }

  public void filterTypeSelected(ActionEvent actionEvent) {
    filterListBox.getItems().clear();

    switch (filterComboBox.getValue()) {

      case "All":
        filterListBox.getItems().add("All");
        break;

//      case "HeatsinkCategory":
//        for (HeatsinkCategory category : HeatsinkCategory.values())
//          filterListBox.getItems().add(category.name());
//        break;

      case "Type":
        for (HeatsinkType type : HeatsinkType.values())
          filterListBox.getItems().add(type.name());
        break;

      case "HeatsinkSubType":
        for (HeatsinkSubType subType : HeatsinkSubType.values())
          filterListBox.getItems().add(subType.name());
        break;
    }
  }

  public void subFilterClicked(MouseEvent mouseEvent) {
    populateTable();
  }

  public void strCellCommit(TableColumn.CellEditEvent<Heatsink, String> cellEditEvent) {
//    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
//    if (toggleBatch.isSelected())
//      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    else
//      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    heatsinkTable.refresh();
  }

  public void intCellCommit(TableColumn.CellEditEvent<Heatsink, Integer> cellEditEvent) {
//    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
//    if (toggleBatch.isSelected())
//      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    else
//      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    heatsinkTable.refresh();
  }

//  public void dblCellCommit(TableColumn.CellEditEvent<Heatsink, Double> cellEditEvent) {
//    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
//    if (toggleBatch.isSelected())
//      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    else
//      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    heatsinkTable.refresh();
//  }

  public void boolCellCommit(TableColumn.CellEditEvent<Heatsink, Boolean> cellEditEvent) {
//    Heatsink hs = heatsinkTable.getSelectionModel().getSelectedItem();
//    if (toggleBatch.isSelected())
//      mainController.getHeatsinkList().batchEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    else
//      mainController.getHeatsinkList().singleEdit(hs, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
//    heatsinkTable.refresh();
  }

  public TableView<Heatsink> getTable() {
    return heatsinkTable;
  }

  private HeatsinkTablePrefs getPrefs() {
    return heatsinkTablePrefs;
  }
}
