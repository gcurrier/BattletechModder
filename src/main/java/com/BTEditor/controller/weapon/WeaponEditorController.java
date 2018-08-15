package com.BTEditor.controller.weapon;

import com.BTEditor.Main;
import com.BTEditor.controller.Tag.TagEditorController;
import com.BTEditor.controller.main.MainController;
import com.BTEditor.controller.main.TableViewContextMenuHelper;
import com.BTEditor.controller.prefs.WeaponTablePrefs;
import com.BTEditor.model.enums.Category;
import com.BTEditor.model.enums.WeaponSubType;
import com.BTEditor.model.enums.WeaponType;
import com.BTEditor.model.weapon.Weapon;
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
import javafx.util.Callback;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class WeaponEditorController {
  public WeaponCollection weaponCollection;

  @FXML
  private WeaponTablePrefs weaponTablePrefs;
  @FXML
  private ComboBox<String> filterComboBox;
  @FXML
  private CheckBox toggleStock;
  @FXML
  private CheckBox toggleBatch;
  @FXML
  private ListView<String> filterListBox;

  @FXML
  private TableView<Weapon> weaponTable;
  @FXML
  private TableColumn<Weapon, String> colFilePath;
  @FXML
  private TableColumn<Weapon, String> colFileName;
  @FXML
  private TableColumn<Weapon, String> colName;
  @FXML
  private TableColumn<Weapon, String> colCat;
  @FXML
  private TableColumn<Weapon, String> colType;
  @FXML
  private TableColumn<Weapon, String> colWpnSubType;
  @FXML
  private TableColumn<Weapon, String> colMfr;
  @FXML
  private TableColumn<Weapon, String> colAmmoCat;
  @FXML
  private TableColumn<Weapon, Integer> colAmmoCap;
  @FXML
  private TableColumn<Weapon, Integer> colDmg;
  @FXML
  private TableColumn<Weapon, Integer> colStb;
  @FXML
  private TableColumn<Weapon, Integer> colDmgAdj;
  @FXML
  private TableColumn<Weapon, Integer> colStbAdj;
  @FXML
  private TableColumn<Weapon, String> colDmgPerTon;
  @FXML
  private TableColumn<Weapon, String> colDmgPerHeat;
  @FXML
  private TableColumn<Weapon, String> colStbPerTon;
  @FXML
  private TableColumn<Weapon, String> colStbPerHeat;
  @FXML
  private TableColumn<Weapon, Integer> colHeatDmg;
  @FXML
  private TableColumn<Weapon, Integer> colAccMod;
  @FXML
  private TableColumn<Weapon, Double> colCrit;
  @FXML
  private TableColumn<Weapon, Integer> colHeat;
  @FXML
  private TableColumn<Weapon, Double> colTons;
  @FXML
  private TableColumn<Weapon, String> colBonusA;
  @FXML
  private TableColumn<Weapon, String> colBOnusB;
  @FXML
  private TableColumn<Weapon, Integer> colEvasiveDmgMulti;
  @FXML
  private TableColumn<Weapon, Integer> colPipsIgnored;
  @FXML
  private TableColumn<Weapon, Integer> colDmgVar;
  @FXML
  private TableColumn<Weapon, Boolean> colAOECapable;
  @FXML
  private TableColumn<Weapon, Boolean> colIndirectCapable;
  @FXML
  private TableColumn<Weapon, Integer> colOverHeatDmgMulti;
  @FXML
  private TableColumn<Weapon, Integer> colMinRange;
  @FXML
  private TableColumn<Weapon, Integer> colMaxRange;
  // TODO: make rangeSplit impl less retarded
  @FXML
  private TableColumn<Weapon, Integer> colShortRangeSplit;
  @FXML
  private TableColumn<Weapon, Integer> colMidRangeSplit;
  @FXML
  private TableColumn<Weapon, Integer> colLongRangeSplit;
  @FXML
  private TableColumn<Weapon, Integer> colRefireMod;
  @FXML
  private TableColumn<Weapon, Integer> colShotsWhenFired;
  @FXML
  private TableColumn<Weapon, Integer> colAttackRecoil;
  @FXML
  private TableColumn<Weapon, Integer> colProjectilesPerShot;
  @FXML
  private TableColumn<Weapon, String> colWpnEffectId;
  @FXML
  private TableColumn<Weapon, Integer> colCost;
  @FXML
  private TableColumn<Weapon, Integer> colRarity;
  @FXML
  private TableColumn<Weapon, Boolean> colPurchasable;
  @FXML
  private TableColumn<Weapon, String> colModel;
  @FXML
  private TableColumn<Weapon, String> colId;
  @FXML
  private TableColumn<Weapon, String> colDetails;
  @FXML
  private TableColumn<Weapon, String> colIcon;
  @FXML
  private TableColumn<Weapon, String> colComponentType;
  @FXML
  private TableColumn<Weapon, String> colComponentSubType;
  @FXML
  private TableColumn<Weapon, String> colPrefabId;
  @FXML
  private TableColumn<Weapon, Integer> colBattleValue;
  @FXML
  private TableColumn<Weapon, Integer> colISize;
  @FXML
  private TableColumn<Weapon, String> colAllowedLocations;
  @FXML
  private TableColumn<Weapon, String> colDisallowedLocations;
  @FXML
  private TableColumn<Weapon, Boolean> colCriticalComponent;

  private MainController mainController;

//    private List<TableColumn<Weapon, ?>> tableColumnsFinal;

  @FXML
  private void initialize() {
    filterComboBox.getItems().addAll("All", "Category", "Type", "WeaponSubType");
    toggleStock.setOnAction(event -> populateTable());
    setCellValueFactories();
    setCellFactories();
  }

  public void postInitSetup(MainController mainController) {
    this.mainController = mainController;
//        tableColumnsFinal = Collections.unmodifiableList(new ArrayList<>(table.getColumns()));
    TableViewContextMenuHelper helper = new TableViewContextMenuHelper(weaponTable);
    this.weaponTablePrefs = new WeaponTablePrefs();
    setTablePrefs();
    setTableListeners();
    setTableContextMenu();
    populateTable();
    colFilePath.setStyle("-fx-text-overrun: center-ellipsis ");
  }

  private void setCellValueFactories() {
    for (TableColumn column : weaponTable.getColumns())
      column.setCellValueFactory(new PropertyValueFactory<>(column.getText()));
  }

  private void setCellFactories() {
    colName.setCellFactory(TextFieldTableCell.forTableColumn());
    colCat.setCellFactory(TextFieldTableCell.forTableColumn());
    colType.setCellFactory(TextFieldTableCell.forTableColumn());
    colWpnSubType.setCellFactory(TextFieldTableCell.forTableColumn());
    colCat.setCellFactory(TextFieldTableCell.forTableColumn());
    colMfr.setCellFactory(TextFieldTableCell.forTableColumn());
    colAmmoCat.setCellFactory(TextFieldTableCell.forTableColumn());
    colAmmoCap.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colDmg.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colStb.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colHeatDmg.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colAccMod.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colCrit.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    colTons.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
    colHeat.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colBonusA.setCellFactory(TextFieldTableCell.forTableColumn());
    colBOnusB.setCellFactory(TextFieldTableCell.forTableColumn());
    colEvasiveDmgMulti.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colPipsIgnored.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colDmgVar.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colAOECapable.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    colIndirectCapable.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    colOverHeatDmgMulti.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colMinRange.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colShortRangeSplit.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colMidRangeSplit.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colLongRangeSplit.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colMaxRange.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colRefireMod.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colShotsWhenFired.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colAttackRecoil.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colProjectilesPerShot.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colWpnEffectId.setCellFactory(TextFieldTableCell.forTableColumn());
    colCost.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colRarity.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colPurchasable.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
    colModel.setCellFactory(TextFieldTableCell.forTableColumn());
    colId.setCellFactory(TextFieldTableCell.forTableColumn());
    colDetails.setCellFactory(TextFieldTableCell.forTableColumn());
    colIcon.setCellFactory(TextFieldTableCell.forTableColumn());
    colComponentType.setCellFactory(TextFieldTableCell.forTableColumn());
    colComponentSubType.setCellFactory(TextFieldTableCell.forTableColumn());
    colPrefabId.setCellFactory(TextFieldTableCell.forTableColumn());
    colBattleValue.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colISize.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    colAllowedLocations.setCellFactory(TextFieldTableCell.forTableColumn());
    colDisallowedLocations.setCellFactory(TextFieldTableCell.forTableColumn());
    colCriticalComponent.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
  }

  private void setTablePrefs() {
    for (TableColumn tableColumn : weaponTable.getColumns()) {
      double prefWidth = getPrefs().getColWidth(tableColumn.getText());
      tableColumn.setPrefWidth(prefWidth);
      tableColumn.setVisible(getPrefs().getShowCol("show" + tableColumn.getText()));
    }
  }

  private void setTableListeners() {
    for (TableColumn tableColumn : weaponTable.getColumns()) {

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
    weaponTable.setRowFactory(new Callback<TableView<Weapon>, TableRow<Weapon>>() {
      @Override
      public TableRow<Weapon> call(TableView<Weapon> param) {
        final TableRow<Weapon> row = new TableRow<>();
        final ContextMenu contextMenu = new ContextMenu();

        MenuItem openFile = new MenuItem("Open File");
        openFile.setOnAction(event -> mainController.getWeaponList().openFile(row.getItem()));

        MenuItem openTagEditor = new MenuItem("Edit ComponentTags");
        openTagEditor.setOnAction(event -> {
          try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fx/TagEditor.fxml"));
            Parent root = loader.load();
            TagEditorController controller = loader.getController();
            controller.setup(row.getItem());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.setTitle("Select Weapon Tags");
            stage.showAndWait();
          } catch (Exception e) {
            e.printStackTrace();
          }
        });

        contextMenu.getItems().addAll(openFile, openTagEditor);
        // only display context menu for non-null items:
        row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty())).then(contextMenu).otherwise((ContextMenu) null));
        return row;
      }
    });
  }

  public void populateTable() {
    this.mainController.getWeaponList()
        .filter(
            filterComboBox.getValue(),
            filterListBox
                .getSelectionModel()
                .getSelectedItem(),
            toggleStock.isSelected());
    ObservableList<Weapon> observableList = FXCollections.observableList(mainController.getWeaponList().getWeaponSubList());
    weaponTable.setItems(observableList);
  }

  public void filterTypeSelected(ActionEvent actionEvent) {
    filterListBox.getItems().clear();

    switch (filterComboBox.getValue()) {

      case "All":
        filterListBox.getItems().add("All");
        break;

      case "Category":
        for (Category category : Category.values())
          filterListBox.getItems().add(category.name());
        break;

      case "Type":
        for (WeaponType type : WeaponType.values())
          filterListBox.getItems().add(type.name());
        break;

      case "WeaponSubType":
        for (WeaponSubType subType : WeaponSubType.values())
          filterListBox.getItems().add(subType.name());
        break;
    }
  }

  public void subFilterClicked(MouseEvent mouseEvent) {
    populateTable();
  }

  public void strCellCommit(TableColumn.CellEditEvent<Weapon, String> cellEditEvent) {
    Weapon wpn = weaponTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getWeaponList().batchEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getWeaponList().singleEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    weaponTable.refresh();
  }

  public void intCellCommit(TableColumn.CellEditEvent<Weapon, Integer> cellEditEvent) {
    Weapon wpn = weaponTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getWeaponList().batchEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getWeaponList().singleEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    weaponTable.refresh();
  }

  public void dblCellCommit(TableColumn.CellEditEvent<Weapon, Double> cellEditEvent) {
    Weapon wpn = weaponTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getWeaponList().batchEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getWeaponList().singleEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    weaponTable.refresh();
  }

  public void boolCellCommit(TableColumn.CellEditEvent<Weapon, Boolean> cellEditEvent) {
    Weapon wpn = weaponTable.getSelectionModel().getSelectedItem();
    if (toggleBatch.isSelected())
      mainController.getWeaponList().batchEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    else
      mainController.getWeaponList().singleEdit(wpn, cellEditEvent.getTableColumn().getText(), cellEditEvent.getNewValue());
    weaponTable.refresh();
  }

  public TableView<Weapon> getTable() {
    return weaponTable;
  }

  public WeaponTablePrefs getPrefs() {
    return weaponTablePrefs;
  }
}
