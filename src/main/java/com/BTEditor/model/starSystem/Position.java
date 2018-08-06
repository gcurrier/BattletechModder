package com.BTEditor.model.starSystem;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "x","y","z"
})
public class Position {

	@JsonProperty("x")
	private double x;
	@JsonProperty("y")
	private double y;
	@JsonProperty("z")
	private int z;
	
	@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
	@JsonProperty("x")
	 public double getX() {
		return x;
	}
	@JsonProperty("x")
	public void setX(double x) {
		this.x = x;
	}
	@JsonProperty("y")
	public double getY() {
		return y;
	}
	@JsonProperty("y")
	public void setY(double y) {
		this.y = y;
	}
	@JsonProperty("z")
	public int getZ() {
		return z;
	}
	@JsonProperty("z")
	public void setZ(int z) {
		this.z = z;
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
