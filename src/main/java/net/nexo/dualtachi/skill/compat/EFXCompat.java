package net.nexo.dualtachi.skill.compat;

import java.util.function.Function;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.nexo.dualtachi.EFDT;
import net.nexo.dualtachi.gameasset.animation.DTAnimations;
import net.nexo.dualtachi.gameasset.animation.DTCollider;
import net.nexo.dualtachi.skill.DTSkills;
import net.nexo.dualtachi.world.capabilities.item.DTWeaponCategories;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.compat.ICompatModule;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

public class EFXCompat implements ICompatModule {
    private static final ResourceLocation TACHI = ResourceLocation.fromNamespaceAndPath("epicfight", "tachi");

    private static void register(WeaponCapabilityPresetRegistryEvent event) {
        Function<Item, CapabilityItem.Builder> base = event.getTypeEntry().get(TACHI);
        Function<Item, CapabilityItem.Builder> patched = item -> patch((WeaponCapability.Builder)base.apply(item));
        event.getTypeEntry().put(TACHI, patched);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(EFDT.MODID, "dt_tachi"), patched);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(EFDT.MODID, "efx_dt_tachi"), patched);
    }

    private static WeaponCapability.Builder patch(WeaponCapability.Builder builder) {
        return builder
                .category(DTWeaponCategories.DT_TACHI)
                .collider(DTCollider.TACHI)
                .canBePlacedOffhand(true)
                .weaponCombinationPredicator(patch -> patch.getHoldingItemCapability(InteractionHand.OFF_HAND)
                        .getWeaponCategory() == DTWeaponCategories.DT_TACHI)
                .styleProvider(patch -> patch.getHoldingItemCapability(InteractionHand.OFF_HAND)
                        .getWeaponCategory() == DTWeaponCategories.DT_TACHI
                        ? CapabilityItem.Styles.OCHS : CapabilityItem.Styles.TWO_HAND)
                .innateSkill(CapabilityItem.Styles.OCHS, stack -> DTSkills.RAGING_TEMPEST)
                .newStyleCombo(CapabilityItem.Styles.OCHS,
                        DTAnimations.DUAL_TACHI_ATTACK1,
                        DTAnimations.DUAL_TACHI_ATTACK2,
                        DTAnimations.DUAL_TACHI_ATTACK3,
                        DTAnimations.DUAL_TACHI_ATTACK4,
                        DTAnimations.DUAL_TACHI_DASH,
                        DTAnimations.DUAL_TACHI_AIRSLASH)
                .livingMotionModifier(CapabilityItem.Styles.OCHS, LivingMotions.IDLE, DTAnimations.DUAL_TACHI_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.OCHS, LivingMotions.BLOCK, Animations.SWORD_DUAL_GUARD)
                .livingMotionModifier(CapabilityItem.Styles.OCHS, LivingMotions.WALK, DTAnimations.DUAL_TACHI_WALK)
                .livingMotionModifier(CapabilityItem.Styles.OCHS, LivingMotions.RUN, DTAnimations.DUAL_TACHI_RUN);
    }

    @Override
    public void onModEventBus(IEventBus eventBus) {
        eventBus.addListener(EventPriority.LOWEST, EFXCompat::register);
    }

    @Override
    public void onForgeEventBus(IEventBus eventBus) { }

    @Override
    public void onModEventBusClient(IEventBus eventBus) { }

    @Override
    public void onForgeEventBusClient(IEventBus eventBus) { }
}
