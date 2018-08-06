package com.BTEditor.model.starSystem;

import com.BTEditor.model.common.Description;
import com.BTEditor.model.common.Tags;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Description", "Position", "Tags", "FuelingStation", "JumpDistance", "Owner", "ShopRefreshRate",
		"ShopMaxInventory", "ShopMaxSpecials", "SystemInfluence", "Difficulty", "TravelRequirements", "MapRequiredTags",
		"MapExcludedTags", "SupportedBiomes", "StarType", "ContractEmployers", "ContractTargets" })
public class StarSystem {

	@JsonProperty("Description")
	private Description description;
	@JsonProperty("Position")
	private Position position;
	@JsonProperty("Tags")
	private Tags tags;
	@JsonProperty("FuelingStation")
	private boolean fuelingStation;
	@JsonProperty("JumpDistance")
	private int jumpDistance;
	@JsonProperty("Owner")
	private String owner;
	@JsonProperty("ShopRefreshRate")
	private int shopRefreshRate;
	@JsonProperty("ShopMaxInventory")
	private int shopMaxInventory;
	@JsonProperty("ShopMaxSpecials")
	private int shopMaxSpecials;
	@JsonProperty("SystemInfluence")
	private SystemInfluence systemInfluence;
	@JsonProperty("Difficulty")
	private int difficulty;
	@JsonProperty("TravelRequirements")
	private TravelRequirements travelRequirements;
	@JsonProperty("MapRequiredTags")
	private Tags mapRequiredTags;
	@JsonProperty("MapExcludedTags")
	private Tags mapExcludedtags;
	@JsonProperty("SupportedBiomes")
	private List<String> supportedBiomes;
	@JsonProperty("StarType")
	private String starType;
	@JsonProperty("ContractEmployers")
	private List<String> contractEmployers;
	@JsonProperty("ContractTargets")
	private List<String> contractTargets;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Description")
	public Description getDescription() {
		return description;
	}

	@JsonProperty("Description")
	public void setDescription(Description description) {
		this.description = description;
	}

	@JsonProperty("Position")
	public Position getPosition() {
		return position;
	}

	@JsonProperty("Position")
	public void setPosition(Position position) {
		this.position = position;
	}

	@JsonProperty("Tags")
	public Tags getTags() {
		return tags;
	}

	@JsonProperty("Tags")
	public void setTags(Tags tags) {
		this.tags = tags;
	}

	@JsonProperty("FuelingStation")
	public boolean isFuelingStation() {
		return fuelingStation;
	}

	@JsonProperty("FuelingStation")
	public void setFuelingStation(boolean fuelingStation) {
		this.fuelingStation = fuelingStation;
	}

	@JsonProperty("JumpDistance")
	public int getJumpDistance() {
		return jumpDistance;
	}

	@JsonProperty("JumpDistance")
	public void setJumpDistance(int jumpDistance) {
		this.jumpDistance = jumpDistance;
	}

	@JsonProperty("Owner")
	public String getOwner() {
		return owner;
	}

	@JsonProperty("Owner")
	public void setOwner(String owner) {
		this.owner = owner;
	}

	@JsonProperty("ShopRefreshRate")
	public int getShopRefreshRate() {
		return shopRefreshRate;
	}

	@JsonProperty("ShopRefreshRate")
	public void setShopRefreshRate(int shopRefreshRate) {
		this.shopRefreshRate = shopRefreshRate;
	}

	@JsonProperty("ShopMaxInventory")
	public int getShopMaxInventory() {
		return shopMaxInventory;
	}

	@JsonProperty("ShopMaxInventory")
	public void setShopMaxInventory(int shopMaxInventory) {
		this.shopMaxInventory = shopMaxInventory;
	}

	@JsonProperty("ShopMaxSpecials")
	public int getShopMaxSpecials() {
		return shopMaxSpecials;
	}

	@JsonProperty("ShopMaxSpecials")
	public void setShopMaxSpecials(int shopMaxSpecials) {
		this.shopMaxSpecials = shopMaxSpecials;
	}

	@JsonProperty("SystemInfluence")
	public SystemInfluence getSystemInfluence() {
		return systemInfluence;
	}

	@JsonProperty("SystemInfluence")
	public void setSystemInfluence(SystemInfluence systemInfluence) {
		this.systemInfluence = systemInfluence;
	}

	@JsonProperty("Difficulty")
	public int getDifficulty() {
		return difficulty;
	}

	@JsonProperty("Difficulty")
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	@JsonProperty("TravelRequirements")
	public TravelRequirements getTravelRequirements() {
		return travelRequirements;
	}

	@JsonProperty("TravelRequirements")
	public void setTravelRequirements(TravelRequirements travelRequirements) {
		this.travelRequirements = travelRequirements;
	}

	@JsonProperty("MapRequiredTags")
	public Tags getMapRequiredTags() {
		return mapRequiredTags;
	}

	@JsonProperty("MapRequiredTags")
	public void setMapRequiredTags(Tags mapRequiredTags) {
		this.mapRequiredTags = mapRequiredTags;
	}

	@JsonProperty("MapExcludedTags")
	public Tags getMapExcludedtags() {
		return mapExcludedtags;
	}

	@JsonProperty("MapExcludedTags")
	public void setMapExcludedtags(Tags mapExcludedtags) {
		this.mapExcludedtags = mapExcludedtags;
	}

	@JsonProperty("SupportedBiomes")
	public List<String> getSupportedBiomes() {
		return supportedBiomes;
	}

	@JsonProperty("SupportedBiomes")
	public void setSupportedBiomes(List<String> supportedBiomes) {
		this.supportedBiomes = supportedBiomes;
	}

	@JsonProperty("StarType")
	public String getStarType() {
		return starType;
	}

	@JsonProperty("StarType")
	public void setStarType(String starType) {
		this.starType = starType;
	}

	@JsonProperty("ContractEmployers")
	public List<String> getContractEmployers() {
		return contractEmployers;
	}

	@JsonProperty("ContractEmployers")
	public void setContractEmployers(List<String> contractEmployers) {
		this.contractEmployers = contractEmployers;
	}

	@JsonProperty("ContractTargets")
	public List<String> getContractTargets() {
		return contractTargets;
	}

	@JsonProperty("ContractTargets")
	public void setContractTargets(List<String> contractTargets) {
		this.contractTargets = contractTargets;
	}

	@JsonIgnore
	private String fileName;
	@JsonIgnore
	private String filePath;

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
