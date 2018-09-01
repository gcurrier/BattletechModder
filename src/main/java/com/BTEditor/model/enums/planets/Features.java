package com.BTEditor.model.enums.planets;

public enum Features {
  ASTEROIDS("planet_feature_asteroids"),
  COMET("planet_feature_comet"),
  GASGIANT("planet_feature_gasgiant"),
  MOON01("planet_feature_moon01"),
  MOON02("planet_feature_moon02"),
  MOON03("planet_feature_moon03"),
  RINGS("planet_feature_rings");

  private String featureType;

  Features(String civType) {
    this.featureType = civType;
  }

  public String getTag() {
    return featureType;
  }
}
