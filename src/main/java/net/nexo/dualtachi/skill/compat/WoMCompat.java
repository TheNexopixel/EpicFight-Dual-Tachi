package net.nexo.dualtachi.skill.compat;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegisterEvent;
import net.nexo.dualtachi.world.capabilities.item.DTWeaponCategories;
import org.checkerframework.checker.units.qual.A;
import reascer.wom.gameasset.WOMAnimations;
import reascer.wom.gameasset.WOMSkills;

import reascer.wom.gameasset.animations.weapons.AnimsHerrscher;
import reascer.wom.gameasset.animations.weapons.AnimsNova;
import reascer.wom.world.capabilities.item.GesetzCapability;
import reascer.wom.world.capabilities.item.WOMWeaponCategories;
import reascer.wom.world.item.WOMItems;
import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;
import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.item.EpicFightItems;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

@SuppressWarnings("unchecked")
public class WoMCompat implements ICompatModule {
    public static void registerGuard(Event event) {
    }

    @Override
    public void onModEventBus(IEventBus iEventBus) {
    }
    @Override
    public void onForgeEventBus(IEventBus iEventBus) {
    }
    @Override
    public void onModEventBusClient(IEventBus iEventBus) {
    }
    @Override
    public void onForgeEventBusClient(IEventBus iEventBus) {
    }

    public static void regIcon(WeaponCategoryIconRegisterEvent event) {
        event.registerCategory(DTWeaponCategories.DT_TACHI, new ItemStack(EpicFightItems.IRON_TACHI.get()));
    }

    public static boolean regGuarded = false;

    public static void buildSkillEvent(RegisterEvent event) {
        if (EpicFightSkills.GUARD == null) {
            return;
        }
        if (regGuarded) {
            return;
        }
        try {
            regGuard();
        } catch (Exception e) {
            e.printStackTrace();
        }
        regGuarded = true;
    }

    public static void regGuard() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> guardMotions = new HashMap<>();
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> guardBreakMotions = new HashMap<>();
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> advancedGuardMotions = new HashMap<>();


        guardMotions.put(DTWeaponCategories.DT_TACHI, (item, player) ->
                AnimsNova.NOVA_GUARD_HIT_1);
        guardBreakMotions.put(DTWeaponCategories.DT_TACHI, (item, player) ->
                Animations.BIPED_COMMON_NEUTRALIZED);
        advancedGuardMotions.put(DTWeaponCategories.DT_TACHI, (itemCap, playerpatch) ->
                Animations.TACHI_AUTO1);



        Field temp;
        Map<WeaponCategory, BiFunction<CapabilityItem, PlayerPatch<?>, ?>> target;
        temp = GuardSkill.class.getDeclaredField("guardMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : guardMotions.keySet()) {
            target.put(weaponCapability, guardMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.VENGEFUL_PARRY);
        for (WeaponCategory weaponCapability : guardMotions.keySet()) {
            target.put(weaponCapability, guardMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.PERFECT_BULWARK);
        for (WeaponCategory weaponCapability : guardMotions.keySet()) {
            target.put(weaponCapability, guardMotions.get(weaponCapability));
        }

        temp = GuardSkill.class.getDeclaredField("guardBreakMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : guardBreakMotions.keySet()) {
            target.put(weaponCapability, guardBreakMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.VENGEFUL_PARRY);
        for (WeaponCategory weaponCapability : guardBreakMotions.keySet()) {
            target.put(weaponCapability, guardBreakMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.PERFECT_BULWARK);
        for (WeaponCategory weaponCapability : guardBreakMotions.keySet()) {
            target.put(weaponCapability, guardBreakMotions.get(weaponCapability));
        }

        temp = GuardSkill.class.getDeclaredField("advancedGuardMotions");
        temp.setAccessible(true);
        target = (Map) temp.get(WOMSkills.COUNTER_ATTACK);
        for (WeaponCategory weaponCapability : advancedGuardMotions.keySet()) {
            target.put(weaponCapability, advancedGuardMotions.get(weaponCapability));
        }
        target = (Map) temp.get(WOMSkills.PERFECT_BULWARK);
        for (WeaponCategory weaponCapability : advancedGuardMotions.keySet()) {
            target.put(weaponCapability, advancedGuardMotions.get(weaponCapability));
        }

    }
}
