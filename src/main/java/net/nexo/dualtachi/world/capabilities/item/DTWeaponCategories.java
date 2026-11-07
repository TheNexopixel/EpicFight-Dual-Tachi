package net.nexo.dualtachi.world.capabilities.item;

import yesman.epicfight.world.capabilities.item.WeaponCategory;


public enum DTWeaponCategories implements WeaponCategory {

    DT_TACHI;

    final int id;

    DTWeaponCategories(){this.id = WeaponCategory.ENUM_MANAGER.assign(this);}

    @Override
    public int universalOrdinal() {
        return this.id;
    }
}
