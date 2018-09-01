package com.BTEditor.model.enums.planets;

public enum Event {
  POX("planet_event_pox");

  private String eventType;

  Event(String type) {
    this.eventType = type;
  }

  public String getTag() {
    return eventType;
  }
}
