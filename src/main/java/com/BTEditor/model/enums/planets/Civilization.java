package com.BTEditor.model.enums.planets;

public enum Civilization {
  INNERSPHERE("planet_civ_innersphere"),
  PERIPHERY("planet_civ_periphery"),
  PRIMITIVE("planet_civ_primitive");

  private String civilizationType;

  Civilization(String civType) {
    this.civilizationType = civType;
  }

  // accessed via planets.Civilization.INNERSPHERE.getTag();

  public String getTag() {
    return civilizationType;
  }
}
