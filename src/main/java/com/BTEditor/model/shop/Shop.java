package com.BTEditor.model.shop;

import com.BTEditor.model.common.Tags;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ID", "RequirementTags", "ExclusionTags", "Inventory", "Specials" })
public class Shop {

	@JsonProperty("ID")
	private String id;
	@JsonProperty("RequirementTags")
	private Tags requirementTags;
	@JsonProperty("ExclusionTags")
	private Tags exclusionTags;
	@JsonProperty("Inventory")
	private List<ShopInventory> inventory;
	@JsonProperty("Specials")
	private List<ShopSpecials> specials;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonIgnore
	private String fileName;
	@JsonIgnore
	private String filePath;

	@JsonProperty("ID")
	public String getId() {
		return id;
	}

	@JsonProperty("ID")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("RequirementTags")
	public Tags getRequirementTags() {
		return requirementTags;
	}

	@JsonProperty("RequirementTags")
	public void setRequirementTags(Tags requirementTags) {
		this.requirementTags = requirementTags;
	}

	@JsonProperty("ExclusionTags")
	public Tags getExclusionTags() {
		return exclusionTags;
	}

	@JsonProperty("ExclusionTags")
	public void setExclusionTags(Tags exclusionTags) {
		this.exclusionTags = exclusionTags;
	}

	@JsonProperty("Inventory")
	public List<ShopInventory> getInventory() {
		return inventory;
	}

	@JsonProperty("Inventory")
	public void setInventory(List<ShopInventory> inventory) {
		this.inventory = inventory;
	}

	@JsonProperty("Specials")
	public List<ShopSpecials> getSpecials() {
		return specials;
	}

	@JsonProperty("Specials")
	public void setSpecials(List<ShopSpecials> specials) {
		this.specials = specials;
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

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}
