package com.BTEditor.model.enums.planets;

public enum Industry {
  AGRICULTURE("planet_industry_agriculture"),
  AQUACULTURE("planet_industry_aquaculture"),
  MANUFACTURING("planet_industry_manufacturing"),
  MINING("planet_industry_mining"),
  POOR("planet_industry_poor"),
  RECREATION("planet_industry_recreation"),
  RESEARCH("planet_industry_research"),
  RICH("planet_industry_rich");

  private String industryType;

  Industry(String civType) {
    this.industryType = civType;
  }

  public String getTag() {
    return industryType;
  }
}
