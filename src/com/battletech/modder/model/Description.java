package com.battletech.modder.model;

public class Description {

	// Rarity: 1
	// Details: Large Lasers exhibit a powerful combination of damage, range, and
	// compactness but generate a substantial amount of heat. Like all Lasers, Large
	// Lasers enjoy a baseline accuracy bonus over other weapons.
	// Purchasable: true
	// Manufacturer: ExoStar
	// Model: Large Laser
	// UIName: L Laser +
	// Id: Weapon_Laser_LargeLaser_1-ExoStar
	// Icon: uixSvgIcon_weapon_Energy
	// Cost: 150000
	// Name: L Laser +

	private String	key,value;

	public Description() {
	}

	public Description(String key, String value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
