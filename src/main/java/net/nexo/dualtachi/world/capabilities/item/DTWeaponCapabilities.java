package net.nexo.dualtachi.world.capabilities.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.nexo.dualtachi.EFDT;
import net.nexo.dualtachi.gameasset.animation.DTAnimations;
import net.nexo.dualtachi.gameasset.animation.DTCollider;
import net.nexo.dualtachi.skill.DTSkills;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = EFDT.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class DTWeaponCapabilities {

    public static final Function<Item, CapabilityItem.Builder> DTTACHI = (item) ->
            WeaponCapability.builder()
                    .category(DTWeaponCategories.DT_TACHI)
                    .styleProvider((pp) -> CapabilityItem.Styles.TWO_HAND)
                    .weaponCombinationPredicator((entityPatch) -> EpicFightCapabilities.getItemStackCapability(entityPatch.getOriginal().getOffhandItem()).getWeaponCategory() == DTWeaponCategories.DT_TACHI)
                    .styleProvider((pp) ->
                            pp.getHoldingItemCapability(InteractionHand.OFF_HAND).getWeaponCategory() == DTWeaponCategories.DT_TACHI ? CapabilityItem.Styles.OCHS : CapabilityItem.Styles.TWO_HAND)
                    .collider(DTCollider.TACHI)
                    .hitParticle(EpicFightParticles.HIT_BLADE.get())
                    .swingSound(EpicFightSounds.WHOOSH.get())
                    .hitSound(EpicFightSounds.BLADE_HIT.get())
                    .canBePlacedOffhand(true)
                    .innateSkill(CapabilityItem.Styles.OCHS, ip -> DTSkills.RAGING_TEMPEST)
                    .innateSkill(CapabilityItem.Styles.TWO_HAND, ip -> EpicFightSkills.RUSHING_TEMPO)
                    .newStyleCombo(CapabilityItem.Styles.TWO_HAND,
                            Animations.TACHI_AUTO1,
                            Animations.TACHI_AUTO2,
                            Animations.TACHI_AUTO3,
                            Animations.TACHI_DASH,
                            Animations.LONGSWORD_AIR_SLASH)

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
                    .livingMotionModifier(CapabilityItem.Styles.OCHS, LivingMotions.RUN, DTAnimations.DUAL_TACHI_RUN)


                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FLOAT, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.FALL, Animations.BIPED_HOLD_TACHI)
                    .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.LONGSWORD_GUARD);


    @SubscribeEvent
    public static void WeaponMovesetRegister(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(EFDT.MODID, "dt_tachi"), DTTACHI);
        if (ModList.get().isLoaded("efx")) {
          //  event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(EFDT.MODID, "efx_dt_tachi"), EFX_DT_TACHI);
        }
    }
}
