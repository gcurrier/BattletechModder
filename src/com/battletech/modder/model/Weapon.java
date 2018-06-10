package com.battletech.modder.model;

import java.util.ArrayList;

/**
 * Model class for a Weapon object
 * @author jinx3y
 *
 */
public class Weapon implements IWeapon {
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

	public Weapon() {}

	public Weapon(String category, String type, String minRange, String maxRange, String rangeSplit,
			String ammoCategory, String startingAmmoCapacity, String heatGenerated, String damage,
			String overheatedDamageMultiplier, String evasiveDamageMultiplier, String damageVariance, String heatDamage,
			String accuracyModifier, String criticalChanceMultiplier, String aoeCapable, String indirectFireCapable,
			String refireModifier, String shotsWhenFired, String projectilesPerShot, String attackRecoil,
			String instability, String weaponEffectID, String id, String name, String details, String icon, String cost,
			String rarity, String purchasable, String manufacturer, String model, String uiName, String bonusValueA,
			String bonusValueB, String componentType, String componentSubType, String prefabIdentifier,
			String battleValue, String inventorySize, String tonnage, String allowedLocations,
			String disallowedLocations, String criticalComponent, ArrayList<Weapon> weaponList) {
		super();
		this.category = category;
		this.type = type;
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.rangeSplit = rangeSplit;
		this.ammoCategory = ammoCategory;
		this.startingAmmoCapacity = startingAmmoCapacity;
		this.heatGenerated = heatGenerated;
		this.damage = damage;
		this.overheatedDamageMultiplier = overheatedDamageMultiplier;
		this.evasiveDamageMultiplier = evasiveDamageMultiplier;
		this.damageVariance = damageVariance;
		this.heatDamage = heatDamage;
		this.accuracyModifier = accuracyModifier;
		this.criticalChanceMultiplier = criticalChanceMultiplier;
		this.aoeCapable = aoeCapable;
		this.indirectFireCapable = indirectFireCapable;
		this.refireModifier = refireModifier;
		this.shotsWhenFired = shotsWhenFired;
		this.projectilesPerShot = projectilesPerShot;
		this.attackRecoil = attackRecoil;
		this.instability = instability;
		this.weaponEffectID = weaponEffectID;
		this.id = id;
		this.name = name;
		this.details = details;
		this.icon = icon;
		this.cost = cost;
		this.rarity = rarity;
		this.purchasable = purchasable;
		this.manufacturer = manufacturer;
		this.model = model;
		this.uiName = uiName;
		this.bonusValueA = bonusValueA;
		this.bonusValueB = bonusValueB;
		this.componentType = componentType;
		this.componentSubType = componentSubType;
		this.prefabIdentifier = prefabIdentifier;
		this.battleValue = battleValue;
		this.inventorySize = inventorySize;
		this.tonnage = tonnage;
		this.allowedLocations = allowedLocations;
		this.disallowedLocations = disallowedLocations;
		this.criticalComponent = criticalComponent;
		this.weaponList = weaponList;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setWeaponList(java.util.ArrayList)
	 */
	@Override
	public void setWeaponList (ArrayList<Weapon> weaponList){
		this.weaponList = weaponList;
	}
	
	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getWeaponList()
	 */
	@Override
	public ArrayList<Weapon> getWeaponList (){
		return this.weaponList;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getCategory()
	 */
	@Override
	public String getCategory() {
		return category;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setCategory(java.lang.String)
	 */
	@Override
	public void setCategory(String category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setType(java.lang.String)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getMinRange()
	 */
	@Override
	public String getMinRange() {
		return minRange;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setMinRange(java.lang.String)
	 */
	@Override
	public void setMinRange(String minRange) {
		this.minRange = minRange;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getMaxRange()
	 */
	@Override
	public String getMaxRange() {
		return maxRange;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setMaxRange(java.lang.String)
	 */
	@Override
	public void setMaxRange(String maxRange) {
		this.maxRange = maxRange;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getRangeSplit()
	 */
	@Override
	public String getRangeSplit() {
		return rangeSplit;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setRangeSplit(java.lang.String)
	 */
	@Override
	public void setRangeSplit(String rangeSplit) {
		this.rangeSplit = rangeSplit;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getAmmoCategory()
	 */
	@Override
	public String getAmmoCategory() {
		return ammoCategory;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setAmmoCategory(java.lang.String)
	 */
	@Override
	public void setAmmoCategory(String ammoCategory) {
		this.ammoCategory = ammoCategory;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getStartingAmmoCapacity()
	 */
	@Override
	public String getStartingAmmoCapacity() {
		return startingAmmoCapacity;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setStartingAmmoCapacity(java.lang.String)
	 */
	@Override
	public void setStartingAmmoCapacity(String startingAmmoCapacity) {
		this.startingAmmoCapacity = startingAmmoCapacity;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getHeatGenerated()
	 */
	@Override
	public String getHeatGenerated() {
		return heatGenerated;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setHeatGenerated(java.lang.String)
	 */
	@Override
	public void setHeatGenerated(String heatGenerated) {
		this.heatGenerated = heatGenerated;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getDamage()
	 */
	@Override
	public String getDamage() {
		return damage;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setDamage(java.lang.String)
	 */
	@Override
	public void setDamage(String damage) {
		this.damage = damage;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getOverheatedDamageMultiplier()
	 */
	@Override
	public String getOverheatedDamageMultiplier() {
		return overheatedDamageMultiplier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setOverheatedDamageMultiplier(java.lang.String)
	 */
	@Override
	public void setOverheatedDamageMultiplier(String overheatedDamageMultiplier) {
		this.overheatedDamageMultiplier = overheatedDamageMultiplier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getEvasiveDamageMultiplier()
	 */
	@Override
	public String getEvasiveDamageMultiplier() {
		return evasiveDamageMultiplier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setEvasiveDamageMultiplier(java.lang.String)
	 */
	@Override
	public void setEvasiveDamageMultiplier(String evasiveDamageMultiplier) {
		this.evasiveDamageMultiplier = evasiveDamageMultiplier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getDamageVariance()
	 */
	@Override
	public String getDamageVariance() {
		return damageVariance;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setDamageVariance(java.lang.String)
	 */
	@Override
	public void setDamageVariance(String damageVariance) {
		this.damageVariance = damageVariance;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getHeatDamage()
	 */
	@Override
	public String getHeatDamage() {
		return heatDamage;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setHeatDamage(java.lang.String)
	 */
	@Override
	public void setHeatDamage(String heatDamage) {
		this.heatDamage = heatDamage;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getAccuracyModifier()
	 */
	@Override
	public String getAccuracyModifier() {
		return accuracyModifier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setAccuracyModifier(java.lang.String)
	 */
	@Override
	public void setAccuracyModifier(String accuracyModifier) {
		this.accuracyModifier = accuracyModifier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getCriticalChanceMultiplier()
	 */
	@Override
	public String getCriticalChanceMultiplier() {
		return criticalChanceMultiplier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setCriticalChanceMultiplier(java.lang.String)
	 */
	@Override
	public void setCriticalChanceMultiplier(String criticalChanceMultiplier) {
		this.criticalChanceMultiplier = criticalChanceMultiplier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getAoeCapable()
	 */
	@Override
	public String getAoeCapable() {
		return aoeCapable;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setAoeCapable(java.lang.String)
	 */
	@Override
	public void setAoeCapable(String aoeCapable) {
		this.aoeCapable = aoeCapable;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getIndirectFireCapable()
	 */
	@Override
	public String getIndirectFireCapable() {
		return indirectFireCapable;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setIndirectFireCapable(java.lang.String)
	 */
	@Override
	public void setIndirectFireCapable(String indirectFireCapable) {
		this.indirectFireCapable = indirectFireCapable;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getRefireModifier()
	 */
	@Override
	public String getRefireModifier() {
		return refireModifier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setRefireModifier(java.lang.String)
	 */
	@Override
	public void setRefireModifier(String refireModifier) {
		this.refireModifier = refireModifier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getShotsWhenFired()
	 */
	@Override
	public String getShotsWhenFired() {
		return shotsWhenFired;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setShotsWhenFired(java.lang.String)
	 */
	@Override
	public void setShotsWhenFired(String shotsWhenFired) {
		this.shotsWhenFired = shotsWhenFired;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getProjectilesPerShot()
	 */
	@Override
	public String getProjectilesPerShot() {
		return projectilesPerShot;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setProjectilesPerShot(java.lang.String)
	 */
	@Override
	public void setProjectilesPerShot(String projectilesPerShot) {
		this.projectilesPerShot = projectilesPerShot;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getAttackRecoil()
	 */
	@Override
	public String getAttackRecoil() {
		return attackRecoil;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setAttackRecoil(java.lang.String)
	 */
	@Override
	public void setAttackRecoil(String attackRecoil) {
		this.attackRecoil = attackRecoil;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getInstability()
	 */
	@Override
	public String getInstability() {
		return instability;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setInstability(java.lang.String)
	 */
	@Override
	public void setInstability(String instability) {
		this.instability = instability;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getWeaponEffectID()
	 */
	@Override
	public String getWeaponEffectID() {
		return weaponEffectID;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setWeaponEffectID(java.lang.String)
	 */
	@Override
	public void setWeaponEffectID(String weaponEffectID) {
		this.weaponEffectID = weaponEffectID;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getDetails()
	 */
	@Override
	public String getDetails() {
		return details;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setDetails(java.lang.String)
	 */
	@Override
	public void setDetails(String details) {
		this.details = details;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getIcon()
	 */
	@Override
	public String getIcon() {
		return icon;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setIcon(java.lang.String)
	 */
	@Override
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getCost()
	 */
	@Override
	public String getCost() {
		return cost;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setCost(java.lang.String)
	 */
	@Override
	public void setCost(String cost) {
		this.cost = cost;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getRarity()
	 */
	@Override
	public String getRarity() {
		return rarity;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setRarity(java.lang.String)
	 */
	@Override
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getPurchasable()
	 */
	@Override
	public String getPurchasable() {
		return purchasable;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setPurchasable(java.lang.String)
	 */
	@Override
	public void setPurchasable(String purchasable) {
		this.purchasable = purchasable;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getManufacturer()
	 */
	@Override
	public String getManufacturer() {
		return manufacturer;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setManufacturer(java.lang.String)
	 */
	@Override
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getModel()
	 */
	@Override
	public String getModel() {
		return model;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setModel(java.lang.String)
	 */
	@Override
	public void setModel(String model) {
		this.model = model;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getUiName()
	 */
	@Override
	public String getUiName() {
		return uiName;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setUiName(java.lang.String)
	 */
	@Override
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getBonusValueA()
	 */
	@Override
	public String getBonusValueA() {
		return bonusValueA;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setBonusValueA(java.lang.String)
	 */
	@Override
	public void setBonusValueA(String bonusValueA) {
		this.bonusValueA = bonusValueA;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getBonusValueB()
	 */
	@Override
	public String getBonusValueB() {
		return bonusValueB;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setBonusValueB(java.lang.String)
	 */
	@Override
	public void setBonusValueB(String bonusValueB) {
		this.bonusValueB = bonusValueB;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getComponentType()
	 */
	@Override
	public String getComponentType() {
		return componentType;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setComponentType(java.lang.String)
	 */
	@Override
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getComponentSubType()
	 */
	@Override
	public String getComponentSubType() {
		return componentSubType;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setComponentSubType(java.lang.String)
	 */
	@Override
	public void setComponentSubType(String componentSubType) {
		this.componentSubType = componentSubType;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getPrefabIdentifier()
	 */
	@Override
	public String getPrefabIdentifier() {
		return prefabIdentifier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setPrefabIdentifier(java.lang.String)
	 */
	@Override
	public void setPrefabIdentifier(String prefabIdentifier) {
		this.prefabIdentifier = prefabIdentifier;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getBattleValue()
	 */
	@Override
	public String getBattleValue() {
		return battleValue;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setBattleValue(java.lang.String)
	 */
	@Override
	public void setBattleValue(String battleValue) {
		this.battleValue = battleValue;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getInventorySize()
	 */
	@Override
	public String getInventorySize() {
		return inventorySize;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setInventorySize(java.lang.String)
	 */
	@Override
	public void setInventorySize(String inventorySize) {
		this.inventorySize = inventorySize;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getTonnage()
	 */
	@Override
	public String getTonnage() {
		return tonnage;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setTonnage(java.lang.String)
	 */
	@Override
	public void setTonnage(String tonnage) {
		this.tonnage = tonnage;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getAllowedLocations()
	 */
	@Override
	public String getAllowedLocations() {
		return allowedLocations;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setAllowedLocations(java.lang.String)
	 */
	@Override
	public void setAllowedLocations(String allowedLocations) {
		this.allowedLocations = allowedLocations;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getDisallowedLocations()
	 */
	@Override
	public String getDisallowedLocations() {
		return disallowedLocations;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setDisallowedLocations(java.lang.String)
	 */
	@Override
	public void setDisallowedLocations(String disallowedLocations) {
		this.disallowedLocations = disallowedLocations;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#getCriticalComponent()
	 */
	@Override
	public String getCriticalComponent() {
		return criticalComponent;
	}

	/* (non-Javadoc)
	 * @see com.battletech.modder.model.IWeapon#setCriticalComponent(java.lang.String)
	 */
	@Override
	public void setCriticalComponent(String criticalComponent) {
		this.criticalComponent = criticalComponent;
	}

}
