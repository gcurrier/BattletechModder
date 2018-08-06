package com.BTEditor.model.shop;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ID", "Type", "DiscountModifier", "Count", "Weight" })
public class ShopInventory {
	@JsonProperty("ID")
	private String id;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("DiscountModifier")
	private double discountModifier;
	@JsonProperty("Count")
	private int count;
	@JsonProperty("Weight")
	private int weight;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("ID")
	public String getId() {
		return id;
	}

	@JsonProperty("ID")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("Type")
	public String getType() {
		return type;
	}

	@JsonProperty("Type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("DiscountModifier")
	public double getDiscountModifier() {
		return discountModifier;
	}

	@JsonProperty("DiscountModifier")
	public void setDiscountModifier(double discountModifier) {
		this.discountModifier = discountModifier;
	}

	@JsonProperty("Count")
	public int getCount() {
		return count;
	}

	@JsonProperty("Count")
	public void setCount(int count) {
		this.count = count;
	}

	@JsonProperty("Weight")
	public int getWeight() {
		return weight;
	}

	@JsonProperty("Weight")
	public void setWeight(int weight) {
		this.weight = weight;
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
