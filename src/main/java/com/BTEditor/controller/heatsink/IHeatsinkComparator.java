package com.BTEditor.controller.heatsink;

import com.BTEditor.model.heatsink.Heatsink;

import java.util.Comparator;

public class IHeatsinkComparator implements Comparator<Heatsink> {

  @Override
  public int compare(Heatsink hs1, Heatsink hs2) {
//        if (hs1.getType().equals(hs2.getType())) {
//            if (hs1.getWeaponSubType().equals(hs2.getWeaponSubType())) {
//                return hs1.getDescription().getName().compareTo(hs2.getDescription().getName());
//            } else {
//                return WeaponSubType.valueOf(hs1.getWeaponSubType()).compareTo(WeaponSubType.valueOf(hs2.getWeaponSubType()));
//            }
//        } else {
//            return Type.valueOf(hs1.getType()).compareTo(Type.valueOf(hs2.getType()));
//        }
    return 0;
  }
}
