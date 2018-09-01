package com.BTEditor.model.enums.planets;

public enum Progress {
  PROGRESS_1("planet_progress_1"),
  PROGRESS_2("planet_progress_2"),
  PROGRESS_2A("planet_progress_2a"),
  PROGRESS_3("planet_progress_3");

  private String progressType;

  Progress(String civType) {
    this.progressType = civType;
  }

  public String getTag() {
    return progressType;
  }
}
