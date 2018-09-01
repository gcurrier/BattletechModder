package com.BTEditor.model.enums.planets;

public enum Climate {
  ARCTIC("planet_climate_arctic"),
  ARID("planet_climate_arid"),
  DESERT("planet_climate_desert"),
  ICE("planet_climate_ice"),
  LUNAR("planet_climate_lunar"),
  MARS("planet_climate_mars"),
  ROCKY("planet_climate_rocky"),
  TERRAN("planet_climate_terran"),
  TROPICAL("planet_climate_tropical"),
  WATER("planet_climate_water");

  private String climateType;

  Climate(String civType) {
    this.climateType = civType;
  }

  public String getTag() {
    return climateType;
  }
}
