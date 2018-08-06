package com.BTEditor.model.starSystem;

import com.BTEditor.model.common.Tags;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Scope", "RequirementTags", "ExclusionTags", "RequirementComparisons" })
public class TravelRequirements {
	@JsonProperty("Scope")
	private String scope;
	@JsonProperty("RequirementTags")
	private Tags requirementTags;
	@JsonProperty("ExclusionTags")
	private Tags exclusionTags;
	@JsonProperty("RequirementComparisons")
	private List<Object> requirementComparisons;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("Scope")
	public void setScope(String scope) {
		this.scope = scope;
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

	public List<Object> getRequirementComparisons() {
		return requirementComparisons;
	}

	public void setRequirementComparisons(List<Object> requirementComparisons) {
		this.requirementComparisons = requirementComparisons;
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
