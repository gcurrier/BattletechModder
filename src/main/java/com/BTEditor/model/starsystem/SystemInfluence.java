package com.BTEditor.model.starsystem;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Faction", "Influecne" })
public class SystemInfluence {

	@JsonProperty("Faction")
	private String faction;
	@JsonProperty("Influence")
	private int influence;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Faction")
	public String getFaction() {
		return faction;
	}

	@JsonProperty("Faction")
	public void setFaction(String faction) {
		this.faction = faction;
	}

	@JsonProperty("Influence")
	public int getInfluence() {
		return influence;
	}

	@JsonProperty("Influence")
	public void setInfluence(int influence) {
		this.influence = influence;
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
