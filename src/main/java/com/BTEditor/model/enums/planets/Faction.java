package com.BTEditor.model.enums.planets;

public enum Faction {
  DAVION("planet_faction_davion"),
  DIRECTORATE("planet_faction_directorate"),
  INDEPENDENT("planet_faction_independent"),
  LIAO("planet_faction_liao"),
  MAGISTRACY("planet_faction_magistracy"),
  MARIK("planet_faction_marik"),
  NOFACTION("planet_faction_nofaction"),
  RESTORATION("planet_faction_restoration"),
  TAURIAN("planet_faction_taurian");

  private String factionType;

  Faction(String type) {
    this.factionType = type;
  }

  public String getTag() {
    return factionType;
  }
}
