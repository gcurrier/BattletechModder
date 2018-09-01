package com.BTEditor.model.enums.planets;

public enum Other {

  BATTLEFIELD("planet_other_battlefield"),
  BLACKMARKET("planet_other_blackmarket"),
  BOREHOLES("planet_other_boreholes"),
  CAPITAL("planet_other_capital"),
  COMSTAR("planet_other_comstar"),
  EMPTY("planet_other_empty"),
  FLOATINGWORLD("planet_other_floatingworld"),
  FUNGUS("planet_other_fungus"),
  HUB("planet_other_hub"),
  MEGACITY("planet_other_megacity"),
  MEGAFOREST("planet_other_megaforest"),
  MOON("planet_other_moon"),
  MUDFLATS("planet_other_mudflats"),
  NEWCOLONY("planet_other_newcolony"),
  PIRATE("planet_other_pirate"),
  PLAGUE("planet_other_plague"),
  PRISON("planet_other_prison"),
  RUINS("planet_other_ruins"),
  STARLEAGUE("planet_other_starleague"),
  STONEDCARIBOU("planet_other_stonedcaribou"),
  STORMS("planet_other_storms"),
  TAINTEDAIR("planet_other_taintedair"),
  VOLCANIC("planet_other_volcanic");

  private String otherType;

  Other(String civType) {
    this.otherType = civType;
  }

  public String getTag() {
    return otherType;
  }
}
