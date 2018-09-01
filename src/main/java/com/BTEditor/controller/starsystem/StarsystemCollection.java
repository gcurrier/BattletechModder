package com.BTEditor.controller.starsystem;

//import com.BTEditor.controller.weapon.IWeaponComparator;
import com.BTEditor.model.starsystem.Starsystem;
import com.BTEditor.model.weapon.Weapon;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import static com.BTEditor.model.enums.ItemFolders.weapon;

public class StarsystemCollection {
  private String workingDir;

  private ObjectMapper mapper;
  private ObjectWriter writer;
  private ArrayList<File> fileArrayList = new ArrayList<>();

  private ArrayList<Starsystem> starsystemArrayList = new ArrayList<>();
  private ArrayList<Starsystem> starsystemSubList = new ArrayList<>();

  public StarsystemCollection(String path) {
    workingDir = path + "\\" + weapon.name();
    DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
    printer.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
    mapper = new ObjectMapper();
    writer = mapper.writer(printer);

    search(new File(workingDir));

    for (File file : fileArrayList) {
      try {
        Starsystem sys = mapper.readValue(file, Starsystem.class);
        sys.setFileName(file.getName());
        sys.setFilePath(getRelativeFilePath(workingDir, file.getCanonicalPath()).replace(file.getName(), ""));
        starsystemArrayList.add(sys);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public ArrayList<Starsystem> getWeaponArrayList() {
    return starsystemArrayList;
  }

  public void setWeaponArrayList(ArrayList<Starsystem> starsystemArrayList) {
    this.starsystemArrayList = starsystemArrayList;
  }

  private String getRelativeFilePath(String rootString, String fileString) {
    return fileString.replace(rootString + "\\", "");
  }

  /**
   * Recursively populate fileList with all files in folder and subfolders
   *
   * @param baseFile working directory
   */
  private void search(File baseFile) {
    File[] fileList = baseFile.listFiles();
    if (fileList != null) {
      for (File file : fileList) {
        if (file.isDirectory()) {
          search(file);
        } else if (!file.getName().contains("Template") && file.getName().contains(".json") && file.getName().contains("Weapon_")) {
          fileArrayList.add(file);
        }
      }
    }
  }

  @Deprecated
  private boolean isOnIgnoreList(File file) {
    String excludes[] = {
        "Weapon_DFAAttack.json",
        "Weapon_Laser_AI_Imaginary.json",
        "Weapon_MeleeAttack.json",
        "WeaponTemplate.json"};

    for (String exclude : excludes)
      if (file.getName().equals(exclude) || !file.getName().endsWith(".json"))
        return true;

    return false;
  }

  void openFile(Starsystem sys) {
    try {
      Desktop.getDesktop().open(fileArrayList.get(starsystemArrayList.indexOf(sys)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void write() {
    try {
      for (int i = 0; i < fileArrayList.size(); i++) {
        if (!fileArrayList.get(i).getName().contains(starsystemArrayList.get(i).getDescription().getId()))
          throw new FileNotFoundException();

        writer.writeValue(new FileOutputStream(fileArrayList.get(i)), starsystemArrayList.get(i));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void backup(File saveFile) {
    JsonNodeFactory factory = JsonNodeFactory.instance;
    ObjectNode parent = factory.objectNode();
    try {
      for (File file : fileArrayList) {
        parent.set(getRelativeFilePath(workingDir, file.getCanonicalPath()), mapper.readTree(file));
      }
      writer.writeValue(saveFile, parent);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void restore(File restoreFile, String workingDir) {
    try {
      JsonNode jsonNode = mapper.readTree(restoreFile);
      Iterator<String> iterator = jsonNode.fieldNames();
      while (iterator.hasNext()) {
        String name = iterator.next();
        if (jsonNode.get(name) != null) {

          String[] temp = name.split("\\\\");
          StringBuilder dirPath = new StringBuilder(workingDir);
          dirPath.append("\\");
          for (int i = 0; i < temp.length - 1; i++) {
            dirPath.append(temp[i]).append("\\");
          }

          File dir = new File(dirPath.toString());
          if (!dir.exists()) dir.mkdirs();

          writer.writeValue(new File(workingDir + "\\" + name), jsonNode.get(name));
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void filter(String filterType, String filterSubType, boolean stockOnlyFlag) {
    starsystemSubList.clear();
    if (filterType == null)
      filterType = "All";
    switch (filterType) {
      case "All":
        //          if (!stockOnlyFlag || sys.getDescription().getId().contains("STOCK")) {
        //          }
        starsystemSubList.addAll(starsystemArrayList);
        break;

//      case "All (no flipped)":
//        for (Starsystem sys : starsystemArrayList) {
//          if (sys.getCategory().equals(filterSubType) && (!stockOnlyFlag || sys.getDescription().getId().contains("STOCK"))) {
//            starsystemSubList.add(wpn);
//          }
//        }
//        break;
//
//      case "All (no contested)":
//        for (Starsystem sys : starsystemArrayList) {
//          if (sys.getType().equals(filterSubType) && (!stockOnlyFlag || sys.getDescription().getId().contains("STOCK"))) {
//            starsystemSubList.add(wpn);
//          }
//        }
//        break;

//      case "WeaponSubType":
//        for (Starsystem sys : starsystemArrayList) {
//          if (sys.getWeaponSubType().equals(filterSubType) && (!stockOnlyFlag || sys.getDescription().getId().contains("STOCK"))) {
//            starsystemSubList.add(wpn);
//          }
//        }
//        break;
    }
//    starsystemSubList.sort(new IStarsystemComparator());
  }

  void singleEdit(Starsystem sys, String field, String newStr) {
//    switch (field) {
//      case "Name":
//        sys.getDescription().setName(newStr);
//        sys.getDescription().setUIName(newStr);
//        break;
//
//      case "Manufacturer":
//        sys.getDescription().setManufacturer(newStr);
//        break;
//
//      case "BonusValueA":
//        sys.adjustBonus(newStr, 'A');
//        break;
//
//      case "BonusValueB":
//        sys.adjustBonus(newStr, 'B');
//        break;
//
//      case "Category":
//        sys.setCategory(newStr);
//        break;
//
//      case "Type":
//        sys.setType(newStr);
//        break;
//
//      case "WeaponSubType":
//        sys.setWeaponSubType(newStr);
//        break;
//
//      case "AmmoCategory":
//        sys.setAmmoCategory(newStr);
//        break;
//
//      case "WeaponEffectID":
//        sys.setWeaponEffectID(newStr);
//        break;
//
//      case "Model":
//        sys.getDescription().setModel(newStr);
//        break;
//
//      case "Id":
//        sys.getDescription().setId(newStr);
//        break;
//
//      case "Details":
//        sys.getDescription().setDetails(newStr);
//        break;
//
//      case "ComponentType":
//        sys.setComponentType(newStr);
//        break;
//
//      case "ComponentSubType":
//        sys.setComponentSubType(newStr);
//        break;
//
//      case "AllowedLocations":
//        sys.setAllowedLocations(newStr);
//        break;
//
//      case "DisallowedLocations":
//        sys.setDisallowedLocations(newStr);
//        break;
//    }
  }

  void singleEdit(Starsystem sys, String field, Integer newInt) {
//    switch (field) {
//      case "Damage":
//        sys.removeBonuses();
//        sys.setDamage(newInt);
//        sys.applyBonuses();
//        break;
//
//      case "Instability":
//        sys.removeBonuses();
//        sys.setInstability(newInt);
//        sys.applyBonuses();
//        break;
//
//      case "HeatDamage":
//        sys.removeBonuses();
//        sys.setHeatDamage(newInt);
//        sys.applyBonuses();
//        break;
//
//      case "AccuracyModifier":
//        sys.removeBonuses();
//        sys.setAccuracyModifier(newInt);
//        sys.applyBonuses();
//        break;
//
//      case "HeatGenerated":
//        sys.removeBonuses();
//        sys.setHeatGenerated(newInt);
//        sys.applyBonuses();
//        break;
//
//      case "MinRange":
//        sys.setMinRange(newInt);
//        break;
//
//      case "ShortRangeSplit":
//        sys.setShortRangeSplit(newInt);
//        break;
//
//      case "MidRangeSplit":
//        sys.setMidRangeSplit(newInt);
//        break;
//
//      case "LongRangeSplit":
//        sys.setLongRangeSplit(newInt);
//        break;
//
//      case "MaxRange":
//        sys.setMaxRange(newInt);
//        break;
//
//      case "RefireModifier":
//        sys.setRefireModifier(newInt);
//        break;
//
//      case "ShotsWhenFired":
//        sys.setShotsWhenFired(newInt);
//        break;
//
//      case "AttackRecoil":
//        sys.setAttackRecoil(newInt);
//        break;
//
//      case "InventorySize":
//        sys.setInventorySize(newInt);
//        break;
//
//      case "StartingAmmoCapacity":
//        sys.setStartingAmmoCapacity(newInt);
//        break;
//
//      case "OverheatedDamageMultiplier":
//        sys.setOverheatedDamageMultiplier(newInt);
//        break;
//
//      case "EvasiveDamageMultiplier":
//        sys.setEvasiveDamageMultiplier(newInt);
//        break;
//
//      case "EvasivePipsIgnored":
//        sys.setEvasivePipsIgnored(newInt);
//        break;
//
//      case "DamageVariance":
//        sys.setDamageVariance(newInt);
//        break;
//
//      case "ProjectilesPerShot":
//        sys.setProjectilesPerShot(newInt);
//        break;
//
//      case "Cost":
//        sys.getDescription().setCost(newInt);
//        break;
//
//      case "Rarity":
//        sys.getDescription().setRarity(newInt);
//        break;
//
//      case "BattleValue":
//        sys.setBattleValue(newInt);
//        break;
//    }
  }

  void singleEdit(Starsystem sys, String field, Double newDbl) {
//    switch (field) {
//      case "CriticalChanceMultiplier":
//        sys.removeBonuses();
//        sys.setCriticalChanceMultiplier(newDbl);
//        sys.applyBonuses();
//
//      case "Tonnage":
//        sys.setTonnage(newDbl);
//        break;
//    }
  }

  void singleEdit(Starsystem sys, String field, Boolean newBool) {
//    switch (field) {
//      case "Purchasable":
//        sys.getDescription().setPurchasable(newBool);
//        break;
//
//      case "AOECapable":
//        sys.setAOECapable(newBool);
//        break;
//
//      case "IndirectFireCapable":
//        sys.setIndirectFireCapable(newBool);
//        break;
//
//      case "CriticalComponent":
//        sys.setCriticalComponent(newBool);
//        break;
//    }
  }

  void batchEdit(Starsystem item, String field, String newStr) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Starsystem sys : starsystemArrayList) {
      if (sys.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(sys, field, newStr);
      }
    }
  }

  void batchEdit(Starsystem item, String field, Integer newInt) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Starsystem sys : starsystemArrayList) {
      if (sys.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(sys, field, newInt);
      }
    }
  }

  void batchEdit(Starsystem item, String field, Double newDbl) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Starsystem sys : starsystemArrayList) {
      if (sys.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(sys, field, newDbl);
      }
    }
  }

  void batchEdit(Starsystem item, String field, Boolean newBool) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Starsystem sys : starsystemArrayList) {
      if (sys.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(sys, field, newBool);
      }
    }
  }

  ArrayList<Starsystem> getStarsystemSubList() {
    return starsystemSubList;
  }
}
