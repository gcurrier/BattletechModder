package com.BTEditor.model.enums.planets;

public enum Size {
  LARGE("planet_size_large"),
  MEDIUM("planet_size_medium"),
  SMALL("planet_size_small");

  private String sizeType;

  Size(String civType) {
    this.sizeType = civType;
  }

  public String getTag() {
    return sizeType;
  }
}
