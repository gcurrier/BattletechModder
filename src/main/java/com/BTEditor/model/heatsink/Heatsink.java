package com.BTEditor.model.heatsink;

import com.BTEditor.model.common.Description;
import com.BTEditor.model.common.Tags;
import com.fasterxml.jackson.annotation.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"DissipationCapacity", "Description", "BonusValueA,", "BonusValueB", "ComponentType", "ComponentSubType",
    "PrefabIdentifier", "BattleValue", "InventorySize", "Tonnage", "AllowedLocations", "DisallowedLocations",
    "CriticalComponent", "statusEffects", "ComponentTags"})
public class Heatsink {

  //  @JsonProperty("Category")
//  private String category;
//  @JsonProperty("Type")
//  private String type;
  @JsonProperty("DissipationCapacity")
  private Integer dissipationCapacity;

  @JsonProperty("Description")
  private Description description;

  @JsonProperty("BonusValueA")
  private String bonusValueA;
  @JsonProperty("BonusValueB")
  private String bonusValueB;
  @JsonProperty("ComponentType")
  private String componentType;
  @JsonProperty("ComponentSubType")
  private String componentSubType;
  @JsonProperty("PrefabIdentifier")
  private String prefabIdentifier;
  @JsonProperty("BattleValue")
  private Integer battleValue;
  @JsonProperty("InventorySize")
  private Integer inventorySize;
  @JsonProperty("Tonnage")
  private Integer tonnage;
  @JsonProperty("AllowedLocations")
  private String allowedLocations;
  @JsonProperty("DisallowedLocations")
  private String disallowedLocations;
  @JsonProperty("CriticalComponent")
  private Boolean criticalComponent;

  @JsonProperty("statusEffects")
  private List<Object> statusEffects = null;

  @JsonProperty("ComponentTags")
  private Tags componentTags;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();
  @JsonIgnore
  private String fileName;
  @JsonIgnore
  private String filePath;

  @JsonIgnore
  public void applyBonuses() {
    for (String subString : bonusValueA.split("\\|"))
      applyBonus(subString);

    for (String subString : bonusValueB.split("\\|"))
      applyBonus(subString);
  }

  @JsonIgnore
  public void removeBonuses() {
    for (String subString : bonusValueA.split("\\|"))
      removeBonus(subString);

    for (String subString : bonusValueB.split("\\|"))
      removeBonus(subString);
  }

  @JsonIgnore
  public void adjustBonus(String newBonus, char whichBonus) {
    if (whichBonus == 'A') {
      for (String bonus : bonusValueA.split("\\|"))
        removeBonus(bonus);
      bonusValueA = newBonus;
    }

    if (whichBonus == 'B') {
      for (String bonus : bonusValueB.split("\\|"))
        removeBonus(bonus);
      bonusValueB = newBonus;
    }

    for (String bonus : newBonus.split("\\|"))
      applyBonus(bonus);
  }

  @JsonIgnore
  private void applyBonus(String bonus) {
    if (bonus.equals(""))
      return;

    if (bonus.charAt(0) == '-')
      subtractBonusValue(bonus);

    else
      addBonusValue(bonus);
  }

  @JsonIgnore
  private void removeBonus(String bonus) {
    if (bonus.equals(""))
      return;

    if (bonus.charAt(0) == '-')
      addBonusValue(bonus);

    else
      subtractBonusValue(bonus);
  }

  @JsonIgnore
  private void addBonusValue(String bonus) {
    //TODO specific bonuses for heatsinks
//    if (bonus.contains(" Dmg.")) {
//      damage += bonusValue(bonus);
//    }
//    if (bonus.contains(" Stb.Dmg.")) {
//      instability += bonusValue(bonus);
//    }
//    if (bonus.contains(" Acc.")) {
//      accuracyModifier -= bonusValue(bonus);
//    }
//    if (bonus.contains(" Crit.")) {
//      criticalChanceMultiplier += bonusValue(bonus) / 100D;
//    }
//    if (bonus.contains(" Heat.")) {
//      heatGenerated += bonusValue(bonus);
//    }
//    if (bonus.contains(" Dmg. (H)"))
//      heatDamage += bonusValue(bonus);
  }

  @JsonIgnore
  private void subtractBonusValue(String bonus) {
    //TODO specific bonuses for heatsinks
//    if (bonus.contains(" Dmg.")) {
//      damage -= bonusValue(bonus);
//    }
//    if (bonus.contains(" Stb.Dmg.")) {
//      instability -= bonusValue(bonus);
//    }
//    if (bonus.contains(" Acc.")) {
//      accuracyModifier += bonusValue(bonus);
//    }
//    if (bonus.contains(" Crit.")) {
//      criticalChanceMultiplier -= bonusValue(bonus) / 100D;
//    }
//    if (bonus.contains(" Heat.")) {
//      heatGenerated -= bonusValue(bonus);
//    }
//    if (bonus.contains(" Dmg. (H)"))
//      heatDamage -= bonusValue(bonus);
  }

  @JsonIgnore
  private int bonusValue(String bonus) {
    int i = 0;
    while (i < bonus.length() && !Character.isDigit(bonus.charAt(i)))
      i++;
    int j = i;
    while (j < bonus.length() && Character.isDigit(bonus.charAt(j))) {
      j++;
    }
    return Integer.parseInt(bonus.substring(i, j));
  }

  @JsonIgnore
  private String round(double value) {
    DecimalFormat df = new DecimalFormat("#.##");
    return df.format(value);
  }

//  @JsonProperty("Category")
//  public String getCategory() {
//    return category;
//  }
//
//  @JsonProperty("Category")
//  public void setCategory(String category) {
//    this.category = category;
//  }
//
//  @JsonProperty("Type")
//  public String getType() {
//    return type;
//  }
//
//  @JsonProperty("Type")
//  public void setType(String type) {
//    this.type = type;
//  }

  @JsonProperty("DissipationCapacity")
  public Integer getDissipationCapacity() {
    return dissipationCapacity;
  }

  @JsonProperty("DissipationCapacity")
  public void setDissipationCapacity(Integer dissipationCapacity) {
    this.dissipationCapacity = dissipationCapacity;
  }

  @JsonProperty("Description")
  public Description getDescription() {
    return description;
  }

  @JsonProperty("Description")
  public void setDescription(Description description) {
    this.description = description;
  }

  @JsonProperty("BonusValueA")
  public String getBonusValueA() {
    return bonusValueA;
  }

  @JsonProperty("BonusValueA")
  public void setBonusValueA(String bonusValueA) {
    this.bonusValueA = bonusValueA;
  }

  @JsonProperty("BonusValueB")
  public String getBonusValueB() {
    return bonusValueB;
  }

  @JsonProperty("BonusValueB")
  public void setBonusValueB(String bonusValueB) {
    this.bonusValueB = bonusValueB;
  }

  @JsonProperty("ComponentType")
  public String getComponentType() {
    return componentType;
  }

  @JsonProperty("ComponentType")
  public void setComponentType(String componentType) {
    this.componentType = componentType;
  }

  @JsonProperty("ComponentSubType")
  public String getComponentSubType() {
    return componentSubType;
  }

  @JsonProperty("ComponentSubType")
  public void setComponentSubType(String componentSubType) {
    this.componentSubType = componentSubType;
  }

  @JsonProperty("PrefabIdentifier")
  public String getPrefabIdentifier() {
    return prefabIdentifier;
  }

  @JsonProperty("PrefabIdentifier")
  public void setPrefabIdentifier(String prefabIdentifier) {
    this.prefabIdentifier = prefabIdentifier;
  }

  @JsonProperty("BattleValue")
  public Integer getBattleValue() {
    return battleValue;
  }

  @JsonProperty("BattleValue")
  public void setBattleValue(Integer battleValue) {
    this.battleValue = battleValue;
  }

  @JsonProperty("InventorySize")
  public Integer getInventorySize() {
    return inventorySize;
  }

  @JsonProperty("InventorySize")
  public void setInventorySize(Integer inventorySize) {
    this.inventorySize = inventorySize;
  }

  @JsonProperty("Tonnage")
  public Integer getTonnage() {
    return tonnage;
  }

  @JsonProperty("Tonnage")
  public void setTonnage(Integer tonnage) {
    this.tonnage = tonnage;
  }

  @JsonProperty("AllowedLocations")
  public String getAllowedLocations() {
    return allowedLocations;
  }

  @JsonProperty("AllowedLocations")
  public void setAllowedLocations(String allowedLocations) {
    this.allowedLocations = allowedLocations;
  }

  @JsonProperty("DisallowedLocations")
  public String getDisallowedLocations() {
    return disallowedLocations;
  }

  @JsonProperty("DisallowedLocations")
  public void setDisallowedLocations(String disallowedLocations) {
    this.disallowedLocations = disallowedLocations;
  }

  @JsonProperty("CriticalComponent")
  public Boolean getCriticalComponent() {
    return criticalComponent;
  }

  @JsonProperty("CriticalComponent")
  public void setCriticalComponent(Boolean criticalComponent) {
    this.criticalComponent = criticalComponent;
  }

  @JsonProperty("statusEffects")
  public List<Object> getStatusEffects() {
    return statusEffects;
  }

  @JsonProperty("statusEffects")
  public void setStatusEffects(List<Object> statusEffects) {
    this.statusEffects = statusEffects;
  }

  @JsonProperty("ComponentTags")
  public Tags getComponentTags() {
    return componentTags;
  }

  @JsonProperty("ComponentTags")
  public void setComponentTags(Tags componentTags) {
    this.componentTags = componentTags;
  }

  @JsonIgnore
  public String getManufacturer() {
    return description.getManufacturer();
  }

  @JsonIgnore
  public Integer getCost() {
    return description.getCost();
  }

  @JsonIgnore
  public Integer getRarity() {
    return description.getRarity();
  }

  @JsonIgnore
  public Boolean getPurchasable() {
    return description.getPurchasable();
  }

  @JsonIgnore
  public String getModel() {
    return description.getModel();
  }

  @JsonIgnore
  public String getUIName() {
    return description.getUIName();
  }

  @JsonIgnore
  public String getName() {
    return description.getName();
  }

  @JsonIgnore
  public String getId() {
    return description.getId();
  }

  @JsonIgnore
  public String getDetails() {
    return description.getDetails();
  }

  @JsonIgnore
  public String getIcon() {
    return description.getIcon();
  }

  @JsonIgnore
  public String getFileName() {
    return fileName;
  }

  @JsonIgnore
  public String getFilePath() {
    return filePath;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperties(Map<String, Object> additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @JsonIgnore
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @JsonIgnore
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }


}