package com.BTEditor.model.common;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "items",
        "tagSetSourceFile"
})
public class Tags {

    @JsonProperty("items")
    private List<String> items = null;
    @JsonProperty("tagSetSourceFile")
    private String tagSetSourceFile;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("items")
    public List<String> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<String> items) {
        this.items = items;
    }

    @JsonProperty("tagSetSourceFile")
    public String getTagSetSourceFile() {
        return tagSetSourceFile;
    }

    @JsonProperty("tagSetSourceFile")
    public void setTagSetSourceFile(String tagSetSourceFile) {
        this.tagSetSourceFile = tagSetSourceFile;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
