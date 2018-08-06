package com.BTEditor.model.upgrade;

import com.BTEditor.model.common.Description;
import com.BTEditor.model.common.StatusEffect;
import com.BTEditor.model.common.Tags;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "StatName", "RelativeModifier", "AbsoluteModifier", "Description", "BonusValueA", "BonusValueB",
		"ComponentType", "ComponentSubType", "PrefabIdentifier", "BattleValue", "InventorySize", "Tonnage",
		"AllowedLocations", "DisallowedLocations", "CriticalComponent", "statusEffects", "ComponentTags" })
public class Gyro {
	@JsonProperty("StatName")
	private String statName;
	@JsonProperty("RelativeModifier")
	private int relativeModifier;
	@JsonProperty("AbsoluteModifier")
	private int absoluteModfier;
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
	private Double tonnage;
	@JsonProperty("AllowedLocations")
	private String allowedLocations;
	@JsonProperty("DisallowedLocations")
	private String disallowedLocations;
	@JsonProperty("CriticalComponent")
	private Boolean criticalComponent;
	@JsonProperty("statusEffects")
	private List<StatusEffect> statusEffects = null;
	@JsonProperty("ComponentTags")
	private Tags componentTags;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonIgnore
	private String fileName;
	@JsonIgnore
	private String filePath;

	public String getStatName() {
		return statName;
	}

	public void setStatName(String statName) {
		this.statName = statName;
	}

	public int getRelativeModifier() {
		return relativeModifier;
	}

	public void setRelativeModifier(int relativeModifier) {
		this.relativeModifier = relativeModifier;
	}

	public int getAbsoluteModfier() {
		return absoluteModfier;
	}

	public void setAbsoluteModfier(int absoluteModfier) {
		this.absoluteModfier = absoluteModfier;
	}

	@JsonProperty("BonusValueA")
	public String getBonusValueA() {
		return bonusValueA;
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
	public Double getTonnage() {
		return tonnage;
	}

	@JsonProperty("Tonnage")
	public void setTonnage(Double tonnage) {
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
	public List<StatusEffect> getStatusEffects() {
		return statusEffects;
	}

	@JsonProperty("statusEffects")
	public void setStatusEffects(List<StatusEffect> statusEffects) {
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperties(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonIgnore
	public String getFileName() {
		return fileName;
	}

	@JsonIgnore
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@JsonIgnore
	public String getFilePath() {
		return filePath;
	}

	@JsonIgnore
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
