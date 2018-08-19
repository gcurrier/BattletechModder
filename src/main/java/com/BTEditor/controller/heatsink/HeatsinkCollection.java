package com.BTEditor.controller.heatsink;

import com.BTEditor.model.heatsink.Heatsink;
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

import static com.BTEditor.model.enums.ItemFolders.heatsinks;

public class HeatsinkCollection {
  private String workingDir;

  private ObjectMapper mapper;
  private ObjectWriter writer;
  private ArrayList<File> fileArrayList = new ArrayList<>();

  private ArrayList<Heatsink> heatsinkArrayList = new ArrayList<>();
  private ArrayList<Heatsink> heatsinkSubList = new ArrayList<>();

  public HeatsinkCollection(String path) {
    workingDir = path + "\\" + heatsinks.name();
    DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
    printer.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
    mapper = new ObjectMapper();
    writer = mapper.writer(printer);

    search(new File(workingDir));

    for (File file : fileArrayList) {
      try {
        Heatsink hs = mapper.readValue(file, Heatsink.class);
        hs.setFileName(file.getName());
        hs.setFilePath(getRelativeFilePath(workingDir, file.getCanonicalPath()).replace(file.getName(), ""));
        heatsinkArrayList.add(hs);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public ArrayList<Heatsink> getHeatsinkArrayList() {
    return heatsinkArrayList;
  }

  public void setHeatsinkArrayList(ArrayList<Heatsink> heatsinkArrayList) {
    this.heatsinkArrayList = heatsinkArrayList;
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
        } else if (!file.getName().contains("Template") && file.getName().contains(".json") && file.getName().contains("HeatSink_")) {
          fileArrayList.add(file);
        }
      }
    }
  }

  @Deprecated
  private boolean isOnIgnoreList(File file) {
    String excludes[] = {
        "HeatSink_Template.json"};

    for (String exclude : excludes)
      if (file.getName().equals(exclude) || !file.getName().endsWith(".json"))
        return true;

    return false;
  }

  void openFile(Heatsink hs) {
    try {
      Desktop.getDesktop().open(fileArrayList.get(heatsinkArrayList.indexOf(hs)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void write() {
    try {
      for (int i = 0; i < fileArrayList.size(); i++) {
        if (!fileArrayList.get(i).getName().contains(heatsinkArrayList.get(i).getDescription().getId()))
          throw new FileNotFoundException();

        writer.writeValue(new FileOutputStream(fileArrayList.get(i)), heatsinkArrayList.get(i));
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

  void filter(String filterType) {
    heatsinkSubList.clear();
    if (filterType == null)
      filterType = "All";
    switch (filterType) {
      case "All":
        heatsinkSubList.addAll(heatsinkArrayList);
        break;
      case "Thermal Exchangers":
        for (Heatsink hs : heatsinkArrayList) {
          if (hs.getDescription().getId().contains("Thermal")) {
            heatsinkSubList.add(hs);
          }
        }
        break;
      case "Thermal Banks":
        for (Heatsink hs : heatsinkArrayList) {
          if (hs.getDescription().getId().contains("Bank")) {
            heatsinkSubList.add(hs);
          }
        }
        break;
      case "Heatsinks":
        for (Heatsink hs : heatsinkArrayList) {
          if ((hs.getDescription().getId().contains("Double") || hs.getDescription().getId().contains("Standard")) && !hs.getDescription().getId().contains("Standard-Bank")) {
            heatsinkSubList.add(hs);
          }
        }
        break;
    }
    heatsinkSubList.sort(new IHeatsinkComparator());
  }

  void singleEdit(Heatsink hs, String field, String newStr) {
    switch (field) {
      case "Name":
        hs.getDescription().setName(newStr);
        hs.getDescription().setUIName(newStr);
        break;

      case "Manufacturer":
        hs.getDescription().setManufacturer(newStr);
        break;

      case "BonusValueA":
        hs.adjustBonus(newStr, 'A');
        break;

      case "BonusValueB":
        hs.adjustBonus(newStr, 'B');
        break;

      case "Model":
        hs.getDescription().setModel(newStr);
        break;

      case "Id":
        hs.getDescription().setId(newStr);
        break;

      case "Details":
        hs.getDescription().setDetails(newStr);
        break;

      case "ComponentType":
        hs.setComponentType(newStr);
        break;

      case "ComponentSubType":
        hs.setComponentSubType(newStr);
        break;

      case "AllowedLocations":
        hs.setAllowedLocations(newStr);
        break;

      case "DisallowedLocations":
        hs.setDisallowedLocations(newStr);
        break;
    }
  }

  void singleEdit(Heatsink hs, String field, Integer newInt) {
    switch (field) {
      case "InventorySize":
        hs.setInventorySize(newInt);
        break;

      case "Cost":
        hs.getDescription().setCost(newInt);
        break;

      case "Rarity":
        hs.getDescription().setRarity(newInt);
        break;

      case "BattleValue":
        hs.setBattleValue(newInt);
        break;

      case "Tonnage":
        hs.setBattleValue(newInt);
        break;
    }
  }

  void singleEdit(Heatsink hs, String field, Double newDbl) {
    switch (field) {
      default:
        break;
    }
  }

  void singleEdit(Heatsink hs, String field, Boolean newBool) {
    switch (field) {
      case "Purchasable":
        hs.getDescription().setPurchasable(newBool);
        break;

      case "CriticalComponent":
        hs.setCriticalComponent(newBool);
        break;
    }
  }

  void batchEdit(Heatsink item, String field, String newStr) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Heatsink hs : heatsinkArrayList) {
      if (hs.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(hs, field, newStr);
      }
    }
  }

  void batchEdit(Heatsink item, String field, Integer newInt) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Heatsink hs : heatsinkArrayList) {
      if (hs.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(hs, field, newInt);
      }
    }
  }

  void batchEdit(Heatsink item, String field, Double newDbl) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Heatsink hs : heatsinkArrayList) {
      if (hs.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(hs, field, newDbl);
      }
    }
  }

  void batchEdit(Heatsink item, String field, Boolean newBool) {
    String name = item.getDescription().getName().replaceAll(" \\+", "");
    for (Heatsink hs : heatsinkArrayList) {
      if (hs.getDescription().getName().replaceAll(" \\+", "").equals(name)) {
        singleEdit(hs, field, newBool);
      }
    }
  }

  ArrayList<Heatsink> getHeatsinkSubList() {
    return heatsinkSubList;
  }
}
