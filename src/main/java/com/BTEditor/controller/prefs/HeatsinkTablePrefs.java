package com.BTEditor.controller.prefs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.prefs.Preferences;

public class HeatsinkTablePrefs {

  private Preferences preferences;
  private LinkedList<String> columnVisDefaults = new LinkedList<>();
  private HashMap<String, Integer> columnWidthDefaults = new HashMap<>();

  /**
   * Sets application level preferences by entering a key in registry
   * (HKEY_CURRENT_USER): HKCU\Software\JavaSoft\Prefs\
   */
  public HeatsinkTablePrefs() {
    preferences = Preferences.userRoot().node(this.getClass().getName());
    setColVisDefaults();
    setColWidthDefaults();
  }

  public boolean getShowCol(String key) {
    return preferences.getBoolean(key, columnVisDefaults.contains(key));
  }

  public int getColWidth(String key) {
    return preferences.getInt(key, columnWidthDefaults.getOrDefault(key, 50));
  }

  public void setShowCol(String key, boolean flag) {
    preferences.putBoolean(key, flag);
  }

  public void setColWidth(String key, int width) {
    preferences.putInt(key, width);
  }

  private void setColVisDefaults() {
//    columnVisDefaults.add("showName");
//    columnVisDefaults.add("showManufacturer");
//    columnVisDefaults.add("showDamage");
//    columnVisDefaults.add("showInstability");
//    columnVisDefaults.add("showAccuracyModifier");
//    columnVisDefaults.add("showCriticalChangeMultiplier");
//    columnVisDefaults.add("showHeatGenerated");
//    columnVisDefaults.add("showBonusValueA");
//    columnVisDefaults.add("showBonusValueB");
//    columnVisDefaults.add("showDmgPerTon");
//    columnVisDefaults.add("showDmgPerHeat");
//    columnVisDefaults.add("showStbPerTon");
//    columnVisDefaults.add("showStbPerHeat");
//    columnVisDefaults.add("showCost");
//    columnVisDefaults.add("showRarity");
//    columnVisDefaults.add("showPurchasable");
  }

  private void setColWidthDefaults() {
    columnWidthDefaults.put("NameWidth", 90);
    columnWidthDefaults.put("ManufacturerWidth", 90);
    columnWidthDefaults.put("BonusValueAWidth", 85);
    columnWidthDefaults.put("BonusValueBWidth", 85);
  }
}
