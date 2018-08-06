package com.BTEditor.model.heatsink;

import com.BTEditor.model.common.Description;
import com.BTEditor.model.common.Tags;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "DissipationCapacity", "Description", "BonusValueA,", "BonusValueB", "ComponentType",
		"PrefabIdentifier", "BattleValue", "InventorySize", "Tonnage", "AllowedLocations", "DisallowedLocations",
		"CriticalComponent", "statusEffects", "ComponentTags" })
public class Heatsink {

	@JsonProperty("DissipationCapacity")
	private String dissipationCapacity;
	@JsonProperty("Description")
	private Description description;
	@JsonProperty("BonusValueA")
	private String bonusValueA;
	@JsonProperty("BonusValueB")
	private String bonusValueB;
	@JsonProperty("ComponentType")
	private String componentType;
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
	private List<Object> statusEffects = null;
	@JsonProperty("ComponentTags")
	private Tags componentTags;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonIgnore
	private String fileName;
	@JsonIgnore
	private String filePath;

	@JsonProperty("DissipationCapacity")
	public String getDissipationCapacity() {
		return dissipationCapacity;
	}

	@JsonProperty("DissipationCapacity")
	public void setDissipationCapacity(String dissipationCapacity) {
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
	public void setTonnnage(Double tonnage) {
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
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