package com.battletech.modder.model;

import javafx.beans.property.SimpleStringProperty;

public class Heatsink {

	private SimpleStringProperty manufacturer;
	private SimpleStringProperty model;
	private SimpleStringProperty name;
	private SimpleStringProperty id;

	public SimpleStringProperty modelProperty() {
		if (model == null) {
			model = new SimpleStringProperty(this, "model");
		}
		return model;
	}

	public SimpleStringProperty manufacturerProperty() {
		if (manufacturer == null) {
			manufacturer = new SimpleStringProperty(this, "manufacturer");
		}
		return model;
	}

	public SimpleStringProperty nameProperty() {
		if (name == null) {
			name = new SimpleStringProperty(this, "name");
		}
		return name;
	}

	public SimpleStringProperty idProperty() {
		if (id == null) {
			id = new SimpleStringProperty(this, "id");
		}
		return id;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manfc) {
		manufacturer.set(manfc);
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String mdl) {
		model.set(mdl);
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String nme) {
		name.set(nme);
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String ID) {
		id.set(ID);
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model.get();
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer.get();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name.get();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id.get();
	}

	public Heatsink(String model, String manufacturer, String name, String id) {
		this.manufacturer = new SimpleStringProperty(manufacturer);
		this.model = new SimpleStringProperty(model);
		this.name = new SimpleStringProperty(name);
		this.id = new SimpleStringProperty(id);
	}

}
