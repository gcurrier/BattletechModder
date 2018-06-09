package com.battletech.modder.model;

import java.util.ArrayList;

//import javafx.beans.property.StringProperty;

// String category = "";
// String type = "";
// String minRange = "";
// String maxRange = "";
// String rangeSplit = "";
// String ammoCategory = "";
// String startingAmmoCapacity = "";
// String heatGenerated = "";
// String damage = "";
// String overheatedDamageMultiplier = "";
// String evasiveDamageMultiplier = "";
// String damageVariance = "";
// String heatDamage = "";
// String accuracyModifier = "";
// String criticalChanceMultiplier = "";
// String aoeCapable = "";
// String indirectFireCapable = "";
// String refireModifier = "";
// String shotsWhenFired = "";
// String projectilesPerShot = "";
// String attackRecoil = "";
// String instability = "";
// String weaponEffectID = "";
// String id = "";
// String name = "";
// String details = "";
// String icon = "";
// String cost = "";
// String rarity = "";
// String purchasable = "";
// String manufacturer = "";
// String model = "";
// String uiName = "";
// String bonusValueA = "";
// String bonusValueB = "";
// String componentType = "";
// String componentSubType = "";
// String prefabIdentifier = "";
// String battleValue = "";
// String inventorySize = "";
// String tonnage = "";
// String allowedLocations = "";
// String disallowedLocations = "";
// String criticalComponent = "";

//category = ;  
//type = ;  
//minRange = ;  
//maxRange = ;
//rangeSplit = ;
//ammoCategory = ;
//startingAmmoCapacity = ;
//heatGenerated = ;damage = ;
//overheatedDamageMultiplier = ;
//evasiveDamageMultiplier = ;
//damageVariance = ;heatDamage = ;
//accuracyModifier = ;
//criticalChanceMultiplier = ;
//aoeCapable = ;
//indirectFireCapable = ;
//refireModifier = ;
//shotsWhenFired = ;
//projectilesPerShot = ;
//attackRecoil = ;
//instability = ;
//weaponEffectID = ;
//id = ;
//name = ;
//details = ;
//icon = ;
//cost = ;
//rarity = ;
//purchasable = ;
//manufacturer = ;
//model = ;
//uiName = ;
//bonusValueA = ;
//bonusValueB = ;
//componentType = ;
//componentSubType = ;
//prefabIdentifier = ;
//battleValue = ;
//inventorySize = ;
//tonnage = ;
//allowedLocations = ;
//disallowedLocations = ;
//criticalComponent = ;
//Weapon weapon = new Weapon(
//		category,  
//		type,  
//		minRange,  
//		maxRange,
//		rangeSplit,
//		ammoCategory,
//		startingAmmoCapacity,
//		heatGenerated,damage,
//		overheatedDamageMultiplier,
//		evasiveDamageMultiplier,
//		damageVariance,heatDamage,
//		accuracyModifier,
//		criticalChanceMultiplier,
//		aoeCapable,
//		indirectFireCapable,
//		refireModifier,
//		shotsWhenFired,
//		projectilesPerShot,
//		attackRecoil,
//		instability,
//		weaponEffectID,
//		id,
//		name,
//		details,
//		icon,
//		cost,
//		rarity,
//		purchasable,
//		manufacturer,
//		model,
//		uiName,
//		bonusValueA,
//		bonusValueB,
//		componentType,
//		componentSubType,
//		prefabIdentifier,
//		battleValue,
//		inventorySize,
//		tonnage,
//		allowedLocations,
//		disallowedLocations,
//		criticalComponent
//		);

/**
 * Model class for a Weapon object
 * @author jinx3y
 *
 */
public class Weapon {
	private String category;
	private String type;
	private String minRange;
	private String maxRange;
	private String rangeSplit;
	private String ammoCategory;
	private String startingAmmoCapacity;
	private String heatGenerated;
	private String damage;
	private String overheatedDamageMultiplier;
	private String evasiveDamageMultiplier;
	private String damageVariance;
	private String heatDamage;
	private String accuracyModifier;
	private String criticalChanceMultiplier;
	private String aoeCapable;
	private String indirectFireCapable;
	private String refireModifier;
	private String shotsWhenFired;
	private String projectilesPerShot;
	private String attackRecoil;
	private String instability;
	private String weaponEffectID;
	// begin nested object "Description"
	private String id;
	private String name;
	private String details;
	private String icon;
	private String cost;
	private String rarity;
	private String purchasable;
	private String manufacturer;
	private String model;
	private String uiName;
	// end nested object "Description"
	private String bonusValueA;
	private String bonusValueB;
	private String componentType;
	private String componentSubType;
	private String prefabIdentifier;
	private String battleValue;
	private String inventorySize;
	private String tonnage;
	private String allowedLocations;
	private String disallowedLocations;
	private String criticalComponent;
	
	private ArrayList<Weapon> weaponList;

//	/**
//	 * Default Weapon Constructor
//	 */
//	public Weapon() {
//		this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
//				null, null, null, null, null, null, null, null, null);
//	}
//
//	/**
//	 * Initialized Constructor with data
//	 * @param category
//	 * @param type
//	 * @param minRange
//	 * @param maxRange
//	 * @param rangeSplit
//	 * @param ammoCategory
//	 * @param startingAmmoCapacity
//	 * @param heatGenerated
//	 * @param damage
//	 * @param overheatedDamageMultiplier
//	 * @param evasiveDamageMultiplier
//	 * @param damageVariance
//	 * @param heatDamage
//	 * @param accuracyModifier
//	 * @param criticalChanceMultiplier
//	 * @param aoeCapable
//	 * @param indirectFireCapable
//	 * @param refireModifier
//	 * @param shotsWhenFired
//	 * @param projectilesPerShot
//	 * @param attackRecoil
//	 * @param instability
//	 * @param weaponEffectID
//	 * @param id
//	 * @param name
//	 * @param details
//	 * @param icon
//	 * @param cost
//	 * @param rarity
//	 * @param purchasable
//	 * @param manufacturer
//	 * @param model
//	 * @param uiName
//	 * @param bonusValueA
//	 * @param bonusValueB
//	 * @param componentType
//	 * @param componentSubType
//	 * @param prefabIdentifier
//	 * @param battleValue
//	 * @param inventorySize
//	 * @param tonnage
//	 * @param allowedLocations
//	 * @param disallowedLocations
//	 * @param criticalComponent
//	 */
//	public Weapon(String category, String type, String minRange, String maxRange, String rangeSplit,
//			String ammoCategory, String startingAmmoCapacity, String heatGenerated, String damage,
//			String overheatedDamageMultiplier, String evasiveDamageMultiplier, String damageVariance, String heatDamage,
//			String accuracyModifier, String criticalChanceMultiplier, String aoeCapable, String indirectFireCapable,
//			String refireModifier, String shotsWhenFired, String projectilesPerShot, String attackRecoil,
//			String instability, String weaponEffectID, String id, String name, String details, String icon, String cost,
//			String rarity, String purchasable, String manufacturer, String model, String uiName, String bonusValueA,
//			String bonusValueB, String componentType, String componentSubType, String prefabIdentifier,
//			String battleValue, String inventorySize, String tonnage, String allowedLocations,
//			String disallowedLocations, String criticalComponent) {
//	}
	
	/**
	 * Creates an ArrayList of weapon objects
	 * @param weaponList
	 */
	public void setWeaponList (ArrayList<Weapon> weaponList){
		this.weaponList = weaponList;
	}
	
	/**
	 * Returns an ArrayList of Weapon objects
	 * @return
	 */
	public ArrayList<Weapon> getWeaponList (){
		return this.weaponList;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the minRange
	 */
	public String getMinRange() {
		return minRange;
	}

	/**
	 * @param minRange
	 *            the minRange to set
	 */
	public void setMinRange(String minRange) {
		this.minRange = minRange;
	}

	/**
	 * @return the maxRange
	 */
	public String getMaxRange() {
		return maxRange;
	}

	/**
	 * @param maxRange
	 *            the maxRange to set
	 */
	public void setMaxRange(String maxRange) {
		this.maxRange = maxRange;
	}

	/**
	 * @return the rangeSplit
	 */
	public String getRangeSplit() {
		return rangeSplit;
	}

	/**
	 * @param rangeSplit
	 *            the rangeSplit to set
	 */
	public void setRangeSplit(String rangeSplit) {
		this.rangeSplit = rangeSplit;
	}

	/**
	 * @return the ammoCategory
	 */
	public String getAmmoCategory() {
		return ammoCategory;
	}

	/**
	 * @param ammoCategory
	 *            the ammoCategory to set
	 */
	public void setAmmoCategory(String ammoCategory) {
		this.ammoCategory = ammoCategory;
	}

	/**
	 * @return the startingAmmoCapacity
	 */
	public String getStartingAmmoCapacity() {
		return startingAmmoCapacity;
	}

	/**
	 * @param startingAmmoCapacity
	 *            the startingAmmoCapacity to set
	 */
	public void setStartingAmmoCapacity(String startingAmmoCapacity) {
		this.startingAmmoCapacity = startingAmmoCapacity;
	}

	/**
	 * @return the heatGenerated
	 */
	public String getHeatGenerated() {
		return heatGenerated;
	}

	/**
	 * @param heatGenerated
	 *            the heatGenerated to set
	 */
	public void setHeatGenerated(String heatGenerated) {
		this.heatGenerated = heatGenerated;
	}

	/**
	 * @return the damage
	 */
	public String getDamage() {
		return damage;
	}

	/**
	 * @param damage
	 *            the damage to set
	 */
	public void setDamage(String damage) {
		this.damage = damage;
	}

	/**
	 * @return the overheatedDamageMultiplier
	 */
	public String getOverheatedDamageMultiplier() {
		return overheatedDamageMultiplier;
	}

	/**
	 * @param overheatedDamageMultiplier
	 *            the overheatedDamageMultiplier to set
	 */
	public void setOverheatedDamageMultiplier(String overheatedDamageMultiplier) {
		this.overheatedDamageMultiplier = overheatedDamageMultiplier;
	}

	/**
	 * @return the evasiveDamageMultiplier
	 */
	public String getEvasiveDamageMultiplier() {
		return evasiveDamageMultiplier;
	}

	/**
	 * @param evasiveDamageMultiplier
	 *            the evasiveDamageMultiplier to set
	 */
	public void setEvasiveDamageMultiplier(String evasiveDamageMultiplier) {
		this.evasiveDamageMultiplier = evasiveDamageMultiplier;
	}

	/**
	 * @return the damageVariance
	 */
	public String getDamageVariance() {
		return damageVariance;
	}

	/**
	 * @param damageVariance
	 *            the damageVariance to set
	 */
	public void setDamageVariance(String damageVariance) {
		this.damageVariance = damageVariance;
	}

	/**
	 * @return the heatDamage
	 */
	public String getHeatDamage() {
		return heatDamage;
	}

	/**
	 * @param heatDamage
	 *            the heatDamage to set
	 */
	public void setHeatDamage(String heatDamage) {
		this.heatDamage = heatDamage;
	}

	/**
	 * @return the accuracyModifier
	 */
	public String getAccuracyModifier() {
		return accuracyModifier;
	}

	/**
	 * @param accuracyModifier
	 *            the accuracyModifier to set
	 */
	public void setAccuracyModifier(String accuracyModifier) {
		this.accuracyModifier = accuracyModifier;
	}

	/**
	 * @return the criticalChanceMultiplier
	 */
	public String getCriticalChanceMultiplier() {
		return criticalChanceMultiplier;
	}

	/**
	 * @param criticalChanceMultiplier
	 *            the criticalChanceMultiplier to set
	 */
	public void setCriticalChanceMultiplier(String criticalChanceMultiplier) {
		this.criticalChanceMultiplier = criticalChanceMultiplier;
	}

	/**
	 * @return the aoeCapable
	 */
	public String getAoeCapable() {
		return aoeCapable;
	}

	/**
	 * @param aoeCapable
	 *            the aoeCapable to set
	 */
	public void setAoeCapable(String aoeCapable) {
		this.aoeCapable = aoeCapable;
	}

	/**
	 * @return the indirectFireCapable
	 */
	public String getIndirectFireCapable() {
		return indirectFireCapable;
	}

	/**
	 * @param indirectFireCapable
	 *            the indirectFireCapable to set
	 */
	public void setIndirectFireCapable(String indirectFireCapable) {
		this.indirectFireCapable = indirectFireCapable;
	}

	/**
	 * @return the refireModifier
	 */
	public String getRefireModifier() {
		return refireModifier;
	}

	/**
	 * @param refireModifier
	 *            the refireModifier to set
	 */
	public void setRefireModifier(String refireModifier) {
		this.refireModifier = refireModifier;
	}

	/**
	 * @return the shotsWhenFired
	 */
	public String getShotsWhenFired() {
		return shotsWhenFired;
	}

	/**
	 * @param shotsWhenFired
	 *            the shotsWhenFired to set
	 */
	public void setShotsWhenFired(String shotsWhenFired) {
		this.shotsWhenFired = shotsWhenFired;
	}

	/**
	 * @return the projectilesPerShot
	 */
	public String getProjectilesPerShot() {
		return projectilesPerShot;
	}

	/**
	 * @param projectilesPerShot
	 *            the projectilesPerShot to set
	 */
	public void setProjectilesPerShot(String projectilesPerShot) {
		this.projectilesPerShot = projectilesPerShot;
	}

	/**
	 * @return the attackRecoil
	 */
	public String getAttackRecoil() {
		return attackRecoil;
	}

	/**
	 * @param attackRecoil
	 *            the attackRecoil to set
	 */
	public void setAttackRecoil(String attackRecoil) {
		this.attackRecoil = attackRecoil;
	}

	/**
	 * @return the instability
	 */
	public String getInstability() {
		return instability;
	}

	/**
	 * @param instability
	 *            the instability to set
	 */
	public void setInstability(String instability) {
		this.instability = instability;
	}

	/**
	 * @return the weaponEffectID
	 */
	public String getWeaponEffectID() {
		return weaponEffectID;
	}

	/**
	 * @param weaponEffectID
	 *            the weaponEffectID to set
	 */
	public void setWeaponEffectID(String weaponEffectID) {
		this.weaponEffectID = weaponEffectID;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details
	 *            the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the cost
	 */
	public String getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}

	/**
	 * @return the rarity
	 */
	public String getRarity() {
		return rarity;
	}

	/**
	 * @param rarity
	 *            the rarity to set
	 */
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	/**
	 * @return the purchasable
	 */
	public String getPurchasable() {
		return purchasable;
	}

	/**
	 * @param purchasable
	 *            the purchasable to set
	 */
	public void setPurchasable(String purchasable) {
		this.purchasable = purchasable;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the uiName
	 */
	public String getUiName() {
		return uiName;
	}

	/**
	 * @param uiName
	 *            the uiName to set
	 */
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	/**
	 * @return the bonusValueA
	 */
	public String getBonusValueA() {
		return bonusValueA;
	}

	/**
	 * @param bonusValueA
	 *            the bonusValueA to set
	 */
	public void setBonusValueA(String bonusValueA) {
		this.bonusValueA = bonusValueA;
	}

	/**
	 * @return the bonusValueB
	 */
	public String getBonusValueB() {
		return bonusValueB;
	}

	/**
	 * @param bonusValueB
	 *            the bonusValueB to set
	 */
	public void setBonusValueB(String bonusValueB) {
		this.bonusValueB = bonusValueB;
	}

	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return componentType;
	}

	/**
	 * @param componentType
	 *            the componentType to set
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	/**
	 * @return the componentSubType
	 */
	public String getComponentSubType() {
		return componentSubType;
	}

	/**
	 * @param componentSubType
	 *            the componentSubType to set
	 */
	public void setComponentSubType(String componentSubType) {
		this.componentSubType = componentSubType;
	}

	/**
	 * @return the prefabIdentifier
	 */
	public String getPrefabIdentifier() {
		return prefabIdentifier;
	}

	/**
	 * @param prefabIdentifier
	 *            the prefabIdentifier to set
	 */
	public void setPrefabIdentifier(String prefabIdentifier) {
		this.prefabIdentifier = prefabIdentifier;
	}

	/**
	 * @return the battleValue
	 */
	public String getBattleValue() {
		return battleValue;
	}

	/**
	 * @param battleValue
	 *            the battleValue to set
	 */
	public void setBattleValue(String battleValue) {
		this.battleValue = battleValue;
	}

	/**
	 * @return the inventorySize
	 */
	public String getInventorySize() {
		return inventorySize;
	}

	/**
	 * @param inventorySize
	 *            the inventorySize to set
	 */
	public void setInventorySize(String inventorySize) {
		this.inventorySize = inventorySize;
	}

	/**
	 * @return the tonnage
	 */
	public String getTonnage() {
		return tonnage;
	}

	/**
	 * @param tonnage
	 *            the tonnage to set
	 */
	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}

	/**
	 * @return the allowedLocations
	 */
	public String getAllowedLocations() {
		return allowedLocations;
	}

	/**
	 * @param allowedLocations
	 *            the allowedLocations to set
	 */
	public void setAllowedLocations(String allowedLocations) {
		this.allowedLocations = allowedLocations;
	}

	/**
	 * @return the disallowedLocations
	 */
	public String getDisallowedLocations() {
		return disallowedLocations;
	}

	/**
	 * @param disallowedLocations
	 *            the disallowedLocations to set
	 */
	public void setDisallowedLocations(String disallowedLocations) {
		this.disallowedLocations = disallowedLocations;
	}

	/**
	 * @return the criticalComponent
	 */
	public String getCriticalComponent() {
		return criticalComponent;
	}

	/**
	 * @param criticalComponent
	 *            the criticalComponent to set
	 */
	public void setCriticalComponent(String criticalComponent) {
		this.criticalComponent = criticalComponent;
	}

}
