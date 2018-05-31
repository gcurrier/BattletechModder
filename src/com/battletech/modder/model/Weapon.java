package com.battletech.modder.model;

import javafx.beans.property.StringProperty;

public class Weapon {
	private StringProperty category;
	private StringProperty type;
	private StringProperty minRange;
	private StringProperty maxRange;
	private StringProperty rangeSplit;
	private StringProperty ammoCategory;
	private StringProperty startingAmmoCapacity;
	private StringProperty heatGenerated;
	private StringProperty damage;
	private StringProperty overheatedDamageMultiplier;
	private StringProperty evasiveDamageMultiplier;
	private StringProperty damageVariance;
	private StringProperty heatDamage;
	private StringProperty accuracyModifier;
	private StringProperty criticalChanceMultiplier;
	private StringProperty aoeCapable;
	private StringProperty indirectFireCapable;
	private StringProperty refireModifier;
	private StringProperty shotsWhenFired;
	private StringProperty projectilesPerShot;
	private StringProperty attackRecoil;
	private StringProperty instability;
	private StringProperty weaponEffectID;
	// begin nested object "Description"
	private StringProperty id;
	private StringProperty name;
	private StringProperty details;
	private StringProperty icon;
	private StringProperty cost;
	private StringProperty rarity;
	private StringProperty purchasable;
	private StringProperty manufacturer;
	private StringProperty model;
	private StringProperty uiName;
	// end nested object "Description"
	private StringProperty bonusValueA;
	private StringProperty bonusValueB;
	private StringProperty componentType;
	private StringProperty componentSubType;
	private StringProperty prefabIdentifier;
	private StringProperty battleValue;
	private StringProperty inventorySize;
	private StringProperty tonnage;
	private StringProperty allowedLocations;
	private StringProperty disallowedLocations;
	private StringProperty criticalComponent;

	/**
	 * Default Weapon Constructor
	 */
	public Weapon() {
		this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Initialized Constructor with data
	 * @param category
	 * @param type
	 * @param minRange
	 * @param maxRange
	 * @param rangeSplit
	 * @param ammoCategory
	 * @param startingAmmoCapacity
	 * @param heatGenerated
	 * @param damage
	 * @param overheatedDamageMultiplier
	 * @param evasiveDamageMultiplier
	 * @param damageVariance
	 * @param heatDamage
	 * @param accuracyModifier
	 * @param criticalChanceMultiplier
	 * @param aoeCapable
	 * @param indirectFireCapable
	 * @param refireModifier
	 * @param shotsWhenFired
	 * @param projectilesPerShot
	 * @param attackRecoil
	 * @param instability
	 * @param weaponEffectID
	 * @param id
	 * @param name
	 * @param details
	 * @param icon
	 * @param cost
	 * @param rarity
	 * @param purchasable
	 * @param manufacturer
	 * @param model
	 * @param uiName
	 * @param bonusValueA
	 * @param bonusValueB
	 * @param componentType
	 * @param componentSubType
	 * @param prefabIdentifier
	 * @param battleValue
	 * @param inventorySize
	 * @param tonnage
	 * @param allowedLocations
	 * @param disallowedLocations
	 * @param criticalComponent
	 */
	public Weapon(String category, String type, String minRange, String maxRange, String rangeSplit,
			String ammoCategory, String startingAmmoCapacity, String heatGenerated, String damage,
			String overheatedDamageMultiplier, String evasiveDamageMultiplier, String damageVariance, String heatDamage,
			String accuracyModifier, String criticalChanceMultiplier, String aoeCapable, String indirectFireCapable,
			String refireModifier, String shotsWhenFired, String projectilesPerShot, String attackRecoil,
			String instability, String weaponEffectID, String id, String name, String details, String icon, String cost,
			String rarity, String purchasable, String manufacturer, String model, String uiName, String bonusValueA,
			String bonusValueB, String componentType, String componentSubType, String prefabIdentifier,
			String battleValue, String inventorySize, String tonnage, String allowedLocations,
			String disallowedLocations, String criticalComponent) {
	}

	/**
	 * @return the category
	 */
	public StringProperty getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(StringProperty category) {
		this.category = category;
	}

	/**
	 * @return the type
	 */
	public StringProperty getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(StringProperty type) {
		this.type = type;
	}

	/**
	 * @return the minRange
	 */
	public StringProperty getMinRange() {
		return minRange;
	}

	/**
	 * @param minRange
	 *            the minRange to set
	 */
	public void setMinRange(StringProperty minRange) {
		this.minRange = minRange;
	}

	/**
	 * @return the maxRange
	 */
	public StringProperty getMaxRange() {
		return maxRange;
	}

	/**
	 * @param maxRange
	 *            the maxRange to set
	 */
	public void setMaxRange(StringProperty maxRange) {
		this.maxRange = maxRange;
	}

	/**
	 * @return the rangeSplit
	 */
	public StringProperty getRangeSplit() {
		return rangeSplit;
	}

	/**
	 * @param rangeSplit
	 *            the rangeSplit to set
	 */
	public void setRangeSplit(StringProperty rangeSplit) {
		this.rangeSplit = rangeSplit;
	}

	/**
	 * @return the ammoCategory
	 */
	public StringProperty getAmmoCategory() {
		return ammoCategory;
	}

	/**
	 * @param ammoCategory
	 *            the ammoCategory to set
	 */
	public void setAmmoCategory(StringProperty ammoCategory) {
		this.ammoCategory = ammoCategory;
	}

	/**
	 * @return the startingAmmoCapacity
	 */
	public StringProperty getStartingAmmoCapacity() {
		return startingAmmoCapacity;
	}

	/**
	 * @param startingAmmoCapacity
	 *            the startingAmmoCapacity to set
	 */
	public void setStartingAmmoCapacity(StringProperty startingAmmoCapacity) {
		this.startingAmmoCapacity = startingAmmoCapacity;
	}

	/**
	 * @return the heatGenerated
	 */
	public StringProperty getHeatGenerated() {
		return heatGenerated;
	}

	/**
	 * @param heatGenerated
	 *            the heatGenerated to set
	 */
	public void setHeatGenerated(StringProperty heatGenerated) {
		this.heatGenerated = heatGenerated;
	}

	/**
	 * @return the damage
	 */
	public StringProperty getDamage() {
		return damage;
	}

	/**
	 * @param damage
	 *            the damage to set
	 */
	public void setDamage(StringProperty damage) {
		this.damage = damage;
	}

	/**
	 * @return the overheatedDamageMultiplier
	 */
	public StringProperty getOverheatedDamageMultiplier() {
		return overheatedDamageMultiplier;
	}

	/**
	 * @param overheatedDamageMultiplier
	 *            the overheatedDamageMultiplier to set
	 */
	public void setOverheatedDamageMultiplier(StringProperty overheatedDamageMultiplier) {
		this.overheatedDamageMultiplier = overheatedDamageMultiplier;
	}

	/**
	 * @return the evasiveDamageMultiplier
	 */
	public StringProperty getEvasiveDamageMultiplier() {
		return evasiveDamageMultiplier;
	}

	/**
	 * @param evasiveDamageMultiplier
	 *            the evasiveDamageMultiplier to set
	 */
	public void setEvasiveDamageMultiplier(StringProperty evasiveDamageMultiplier) {
		this.evasiveDamageMultiplier = evasiveDamageMultiplier;
	}

	/**
	 * @return the damageVariance
	 */
	public StringProperty getDamageVariance() {
		return damageVariance;
	}

	/**
	 * @param damageVariance
	 *            the damageVariance to set
	 */
	public void setDamageVariance(StringProperty damageVariance) {
		this.damageVariance = damageVariance;
	}

	/**
	 * @return the heatDamage
	 */
	public StringProperty getHeatDamage() {
		return heatDamage;
	}

	/**
	 * @param heatDamage
	 *            the heatDamage to set
	 */
	public void setHeatDamage(StringProperty heatDamage) {
		this.heatDamage = heatDamage;
	}

	/**
	 * @return the accuracyModifier
	 */
	public StringProperty getAccuracyModifier() {
		return accuracyModifier;
	}

	/**
	 * @param accuracyModifier
	 *            the accuracyModifier to set
	 */
	public void setAccuracyModifier(StringProperty accuracyModifier) {
		this.accuracyModifier = accuracyModifier;
	}

	/**
	 * @return the criticalChanceMultiplier
	 */
	public StringProperty getCriticalChanceMultiplier() {
		return criticalChanceMultiplier;
	}

	/**
	 * @param criticalChanceMultiplier
	 *            the criticalChanceMultiplier to set
	 */
	public void setCriticalChanceMultiplier(StringProperty criticalChanceMultiplier) {
		this.criticalChanceMultiplier = criticalChanceMultiplier;
	}

	/**
	 * @return the aoeCapable
	 */
	public StringProperty getAoeCapable() {
		return aoeCapable;
	}

	/**
	 * @param aoeCapable
	 *            the aoeCapable to set
	 */
	public void setAoeCapable(StringProperty aoeCapable) {
		this.aoeCapable = aoeCapable;
	}

	/**
	 * @return the indirectFireCapable
	 */
	public StringProperty getIndirectFireCapable() {
		return indirectFireCapable;
	}

	/**
	 * @param indirectFireCapable
	 *            the indirectFireCapable to set
	 */
	public void setIndirectFireCapable(StringProperty indirectFireCapable) {
		this.indirectFireCapable = indirectFireCapable;
	}

	/**
	 * @return the refireModifier
	 */
	public StringProperty getRefireModifier() {
		return refireModifier;
	}

	/**
	 * @param refireModifier
	 *            the refireModifier to set
	 */
	public void setRefireModifier(StringProperty refireModifier) {
		this.refireModifier = refireModifier;
	}

	/**
	 * @return the shotsWhenFired
	 */
	public StringProperty getShotsWhenFired() {
		return shotsWhenFired;
	}

	/**
	 * @param shotsWhenFired
	 *            the shotsWhenFired to set
	 */
	public void setShotsWhenFired(StringProperty shotsWhenFired) {
		this.shotsWhenFired = shotsWhenFired;
	}

	/**
	 * @return the projectilesPerShot
	 */
	public StringProperty getProjectilesPerShot() {
		return projectilesPerShot;
	}

	/**
	 * @param projectilesPerShot
	 *            the projectilesPerShot to set
	 */
	public void setProjectilesPerShot(StringProperty projectilesPerShot) {
		this.projectilesPerShot = projectilesPerShot;
	}

	/**
	 * @return the attackRecoil
	 */
	public StringProperty getAttackRecoil() {
		return attackRecoil;
	}

	/**
	 * @param attackRecoil
	 *            the attackRecoil to set
	 */
	public void setAttackRecoil(StringProperty attackRecoil) {
		this.attackRecoil = attackRecoil;
	}

	/**
	 * @return the instability
	 */
	public StringProperty getInstability() {
		return instability;
	}

	/**
	 * @param instability
	 *            the instability to set
	 */
	public void setInstability(StringProperty instability) {
		this.instability = instability;
	}

	/**
	 * @return the weaponEffectID
	 */
	public StringProperty getWeaponEffectID() {
		return weaponEffectID;
	}

	/**
	 * @param weaponEffectID
	 *            the weaponEffectID to set
	 */
	public void setWeaponEffectID(StringProperty weaponEffectID) {
		this.weaponEffectID = weaponEffectID;
	}

	/**
	 * @return the id
	 */
	public StringProperty getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(StringProperty id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public StringProperty getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(StringProperty name) {
		this.name = name;
	}

	/**
	 * @return the details
	 */
	public StringProperty getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(StringProperty details) {
		this.details = details;
	}

	/**
	 * @return the icon
	 */
	public StringProperty getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(StringProperty icon) {
		this.icon = icon;
	}

	/**
	 * @return the cost
	 */
	public StringProperty getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(StringProperty cost) {
		this.cost = cost;
	}

	/**
	 * @return the rarity
	 */
	public StringProperty getRarity() {
		return rarity;
	}

	/**
	 * @param rarity
	 *            the rarity to set
	 */
	public void setRarity(StringProperty rarity) {
		this.rarity = rarity;
	}

	/**
	 * @return the purchasable
	 */
	public StringProperty getPurchasable() {
		return purchasable;
	}

	/**
	 * @param purchasable
	 *            the purchasable to set
	 */
	public void setPurchasable(StringProperty purchasable) {
		this.purchasable = purchasable;
	}

	/**
	 * @return the manufacturer
	 */
	public StringProperty getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(StringProperty manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the model
	 */
	public StringProperty getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(StringProperty model) {
		this.model = model;
	}

	/**
	 * @return the uiName
	 */
	public StringProperty getUiName() {
		return uiName;
	}

	/**
	 * @param uiName
	 *            the uiName to set
	 */
	public void setUiName(StringProperty uiName) {
		this.uiName = uiName;
	}

	/**
	 * @return the bonusValueA
	 */
	public StringProperty getBonusValueA() {
		return bonusValueA;
	}

	/**
	 * @param bonusValueA
	 *            the bonusValueA to set
	 */
	public void setBonusValueA(StringProperty bonusValueA) {
		this.bonusValueA = bonusValueA;
	}

	/**
	 * @return the bonusValueB
	 */
	public StringProperty getBonusValueB() {
		return bonusValueB;
	}

	/**
	 * @param bonusValueB
	 *            the bonusValueB to set
	 */
	public void setBonusValueB(StringProperty bonusValueB) {
		this.bonusValueB = bonusValueB;
	}

	/**
	 * @return the componentType
	 */
	public StringProperty getComponentType() {
		return componentType;
	}

	/**
	 * @param componentType
	 *            the componentType to set
	 */
	public void setComponentType(StringProperty componentType) {
		this.componentType = componentType;
	}

	/**
	 * @return the componentSubType
	 */
	public StringProperty getComponentSubType() {
		return componentSubType;
	}

	/**
	 * @param componentSubType
	 *            the componentSubType to set
	 */
	public void setComponentSubType(StringProperty componentSubType) {
		this.componentSubType = componentSubType;
	}

	/**
	 * @return the prefabIdentifier
	 */
	public StringProperty getPrefabIdentifier() {
		return prefabIdentifier;
	}

	/**
	 * @param prefabIdentifier
	 *            the prefabIdentifier to set
	 */
	public void setPrefabIdentifier(StringProperty prefabIdentifier) {
		this.prefabIdentifier = prefabIdentifier;
	}

	/**
	 * @return the battleValue
	 */
	public StringProperty getBattleValue() {
		return battleValue;
	}

	/**
	 * @param battleValue
	 *            the battleValue to set
	 */
	public void setBattleValue(StringProperty battleValue) {
		this.battleValue = battleValue;
	}

	/**
	 * @return the inventorySize
	 */
	public StringProperty getInventorySize() {
		return inventorySize;
	}

	/**
	 * @param inventorySize
	 *            the inventorySize to set
	 */
	public void setInventorySize(StringProperty inventorySize) {
		this.inventorySize = inventorySize;
	}

	/**
	 * @return the tonnage
	 */
	public StringProperty getTonnage() {
		return tonnage;
	}

	/**
	 * @param tonnage
	 *            the tonnage to set
	 */
	public void setTonnage(StringProperty tonnage) {
		this.tonnage = tonnage;
	}

	/**
	 * @return the allowedLocations
	 */
	public StringProperty getAllowedLocations() {
		return allowedLocations;
	}

	/**
	 * @param allowedLocations
	 *            the allowedLocations to set
	 */
	public void setAllowedLocations(StringProperty allowedLocations) {
		this.allowedLocations = allowedLocations;
	}

	/**
	 * @return the disallowedLocations
	 */
	public StringProperty getDisallowedLocations() {
		return disallowedLocations;
	}

	/**
	 * @param disallowedLocations
	 *            the disallowedLocations to set
	 */
	public void setDisallowedLocations(StringProperty disallowedLocations) {
		this.disallowedLocations = disallowedLocations;
	}

	/**
	 * @return the criticalComponent
	 */
	public StringProperty getCriticalComponent() {
		return criticalComponent;
	}

	/**
	 * @param criticalComponent
	 *            the criticalComponent to set
	 */
	public void setCriticalComponent(StringProperty criticalComponent) {
		this.criticalComponent = criticalComponent;
	}

}
