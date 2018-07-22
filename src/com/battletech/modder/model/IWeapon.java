package com.battletech.modder.model;

import java.util.ArrayList;

import org.json.JSONArray;

public interface IWeapon {

	/**
	 * Creates an ArrayList of weapon objects
	 * @param weaponList
	 */
	void setWeaponList(ArrayList<Weapon> weaponList);

	/**
	 * Returns an ArrayList of Weapon objects
	 * @return
	 */
	ArrayList<Weapon> getWeaponList();

	/**
	 * @return the category
	 */
	String getCategory();

	/**
	 * @param category
	 *            the category to set
	 */
	void setCategory(String category);

	/**
	 * @return the type
	 */
	String getType();

	/**
	 * @param type
	 *            the type to set
	 */
	void setType(String type);

	/**
	 * @return the minRange
	 */
	String getMinRange();

	/**
	 * @param minRange
	 *            the minRange to set
	 */
	void setMinRange(String minRange);

	/**
	 * @return the maxRange
	 */
	String getMaxRange();

	/**
	 * @param maxRange
	 *            the maxRange to set
	 */
	void setMaxRange(String maxRange);

	/**
	 * @return the rangeSplit
	 */
	JSONArray getRangeSplit();

	/**
	 * @param rangeSplit
	 *            the rangeSplit to set
	 */
	void setRangeSplit(JSONArray rangeSplit);

	/**
	 * @return the ammoCategory
	 */
	String getAmmoCategory();

	/**
	 * @param ammoCategory
	 *            the ammoCategory to set
	 */
	void setAmmoCategory(String ammoCategory);

	/**
	 * @return the startingAmmoCapacity
	 */
	String getStartingAmmoCapacity();

	/**
	 * @param startingAmmoCapacity
	 *            the startingAmmoCapacity to set
	 */
	void setStartingAmmoCapacity(String startingAmmoCapacity);

	/**
	 * @return the heatGenerated
	 */
	String getHeatGenerated();

	/**
	 * @param heatGenerated
	 *            the heatGenerated to set
	 */
	void setHeatGenerated(String heatGenerated);

	/**
	 * @return the damage
	 */
	String getDamage();

	/**
	 * @param damage
	 *            the damage to set
	 */
	void setDamage(String damage);

	/**
	 * @return the overheatedDamageMultiplier
	 */
	String getOverheatedDamageMultiplier();

	/**
	 * @param overheatedDamageMultiplier
	 *            the overheatedDamageMultiplier to set
	 */
	void setOverheatedDamageMultiplier(String overheatedDamageMultiplier);

	/**
	 * @return the evasiveDamageMultiplier
	 */
	String getEvasiveDamageMultiplier();

	/**
	 * @param evasiveDamageMultiplier
	 *            the evasiveDamageMultiplier to set
	 */
	void setEvasiveDamageMultiplier(String evasiveDamageMultiplier);

	/**
	 * @return the damageVariance
	 */
	String getDamageVariance();

	/**
	 * @param damageVariance
	 *            the damageVariance to set
	 */
	void setDamageVariance(String damageVariance);

	/**
	 * @return the heatDamage
	 */
	String getHeatDamage();

	/**
	 * @param heatDamage
	 *            the heatDamage to set
	 */
	void setHeatDamage(String heatDamage);

	/**
	 * @return the accuracyModifier
	 */
	String getAccuracyModifier();

	/**
	 * @param accuracyModifier
	 *            the accuracyModifier to set
	 */
	void setAccuracyModifier(String accuracyModifier);

	/**
	 * @return the criticalChanceMultiplier
	 */
	String getCriticalChanceMultiplier();

	/**
	 * @param criticalChanceMultiplier
	 *            the criticalChanceMultiplier to set
	 */
	void setCriticalChanceMultiplier(String criticalChanceMultiplier);

	/**
	 * @return the aoeCapable
	 */
	String getAoeCapable();

	/**
	 * @param aoeCapable
	 *            the aoeCapable to set
	 */
	void setAoeCapable(String aoeCapable);

	/**
	 * @return the indirectFireCapable
	 */
	String getIndirectFireCapable();

	/**
	 * @param indirectFireCapable
	 *            the indirectFireCapable to set
	 */
	void setIndirectFireCapable(String indirectFireCapable);

	/**
	 * @return the refireModifier
	 */
	String getRefireModifier();

	/**
	 * @param refireModifier
	 *            the refireModifier to set
	 */
	void setRefireModifier(String refireModifier);

	/**
	 * @return the shotsWhenFired
	 */
	String getShotsWhenFired();

	/**
	 * @param shotsWhenFired
	 *            the shotsWhenFired to set
	 */
	void setShotsWhenFired(String shotsWhenFired);

	/**
	 * @return the projectilesPerShot
	 */
	String getProjectilesPerShot();

	/**
	 * @param projectilesPerShot
	 *            the projectilesPerShot to set
	 */
	void setProjectilesPerShot(String projectilesPerShot);

	/**
	 * @return the attackRecoil
	 */
	String getAttackRecoil();

	/**
	 * @param attackRecoil
	 *            the attackRecoil to set
	 */
	void setAttackRecoil(String attackRecoil);

	/**
	 * @return the instability
	 */
	String getInstability();

	/**
	 * @param instability
	 *            the instability to set
	 */
	void setInstability(String instability);

	/**
	 * @return the weaponEffectID
	 */
	String getWeaponEffectID();

	/**
	 * @param weaponEffectID
	 *            the weaponEffectID to set
	 */
	void setWeaponEffectID(String weaponEffectID);

	/**
	 * @return the id
	 */
	String getId();

	/**
	 * @param id
	 *            the id to set
	 */
	void setId(String id);

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @param name
	 *            the name to set
	 */
	void setName(String name);

	/**
	 * @return the details
	 */
	String getDetails();

	/**
	 * @param details
	 *            the details to set
	 */
	void setDetails(String details);

	/**
	 * @return the icon
	 */
	String getIcon();

	/**
	 * @param icon
	 *            the icon to set
	 */
	void setIcon(String icon);

	/**
	 * @return the cost
	 */
	String getCost();

	/**
	 * @param cost
	 *            the cost to set
	 */
	void setCost(String cost);

	/**
	 * @return the rarity
	 */
	String getRarity();

	/**
	 * @param rarity
	 *            the rarity to set
	 */
	void setRarity(String rarity);

	/**
	 * @return the purchasable
	 */
	String getPurchasable();

	/**
	 * @param purchasable
	 *            the purchasable to set
	 */
	void setPurchasable(String purchasable);

	/**
	 * @return the manufacturer
	 */
	String getManufacturer();

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	void setManufacturer(String manufacturer);

	/**
	 * @return the model
	 */
	String getModel();

	/**
	 * @param model
	 *            the model to set
	 */
	void setModel(String model);

	/**
	 * @return the uiName
	 */
	String getUiName();

	/**
	 * @param uiName
	 *            the uiName to set
	 */
	void setUiName(String uiName);

	/**
	 * @return the bonusValueA
	 */
	String getBonusValueA();

	/**
	 * @param bonusValueA
	 *            the bonusValueA to set
	 */
	void setBonusValueA(String bonusValueA);

	/**
	 * @return the bonusValueB
	 */
	String getBonusValueB();

	/**
	 * @param bonusValueB
	 *            the bonusValueB to set
	 */
	void setBonusValueB(String bonusValueB);

	/**
	 * @return the componentType
	 */
	String getComponentType();

	/**
	 * @param componentType
	 *            the componentType to set
	 */
	void setComponentType(String componentType);

	/**
	 * @return the componentSubType
	 */
	String getComponentSubType();

	/**
	 * @param componentSubType
	 *            the componentSubType to set
	 */
	void setComponentSubType(String componentSubType);

	/**
	 * @return the prefabIdentifier
	 */
	String getPrefabIdentifier();

	/**
	 * @param prefabIdentifier
	 *            the prefabIdentifier to set
	 */
	void setPrefabIdentifier(String prefabIdentifier);

	/**
	 * @return the battleValue
	 */
	String getBattleValue();

	/**
	 * @param battleValue
	 *            the battleValue to set
	 */
	void setBattleValue(String battleValue);

	/**
	 * @return the inventorySize
	 */
	String getInventorySize();

	/**
	 * @param inventorySize
	 *            the inventorySize to set
	 */
	void setInventorySize(String inventorySize);

	/**
	 * @return the tonnage
	 */
	String getTonnage();

	/**
	 * @param tonnage
	 *            the tonnage to set
	 */
	void setTonnage(String tonnage);

	/**
	 * @return the allowedLocations
	 */
	String getAllowedLocations();

	/**
	 * @param allowedLocations
	 *            the allowedLocations to set
	 */
	void setAllowedLocations(String allowedLocations);

	/**
	 * @return the disallowedLocations
	 */
	String getDisallowedLocations();

	/**
	 * @param disallowedLocations
	 *            the disallowedLocations to set
	 */
	void setDisallowedLocations(String disallowedLocations);

	/**
	 * @return the criticalComponent
	 */
	String getCriticalComponent();

	/**
	 * @param criticalComponent
	 *            the criticalComponent to set
	 */
	void setCriticalComponent(String criticalComponent);
	
	/**
	 * @return the statusEffects
	 */
	JSONArray getStatusEffects();

	/**
	 * @param statusEffects
	 *            the statusEffects to set
	 */
	void setStatusEffects(JSONArray statusEffects);
}