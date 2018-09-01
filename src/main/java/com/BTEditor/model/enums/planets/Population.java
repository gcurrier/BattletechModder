package com.BTEditor.model.enums.planets;

public enum Population {
  LARGE("planet_pop_large"),
  MEDIUM("planet_pop_medium"),
  NONE("planet_pop_none"),
  SMALL("planet_pop_small");

  private String populationType;

  Population(String civType) {
    this.populationType = civType;
  }

  public String getTag() {
    return populationType;
  }
}
