package net.nexo.dualtachi.skill.compat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nexo.dualtachi.EFDT;
import net.nexo.dualtachi.world.capabilities.item.DTWeaponCategories;
import yesman.epicfight.api.client.forgeevent.WeaponCategoryIconRegisterEvent;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.passive.SwordmasterSkill;
import yesman.epicfight.world.item.EpicFightItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = EFDT.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EpicFightSkillCompat {


    @SubscribeEvent
    public static void onGuardSkillcreate(SkillBuildEvent.ModRegistryWorker.SkillCreateEvent<GuardSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "guard"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();

            builder.addGuardMotion(
                    DTWeaponCategories.DT_TACHI,
                    (i, p) -> Animations.LONGSWORD_GUARD_HIT
            ).addGuardBreakMotion(DTWeaponCategories.DT_TACHI,
                    (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);
        }
    }
    @SubscribeEvent
    public static void onImpactGuardSkillcreate(SkillBuildEvent.ModRegistryWorker.SkillCreateEvent<GuardSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "impact_guard"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();

            builder.addGuardMotion(
                    DTWeaponCategories.DT_TACHI,
                    (i, p) -> Animations.LONGSWORD_GUARD_HIT
            ).addGuardBreakMotion(DTWeaponCategories.DT_TACHI,
                    (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED);
        }
    }
    @SubscribeEvent
    public static void onParrySkillcreate(SkillBuildEvent.ModRegistryWorker.SkillCreateEvent<GuardSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight", "parrying"))) {
            GuardSkill.Builder builder = event.getSkillBuilder();

            builder.addGuardMotion(
                            DTWeaponCategories.DT_TACHI,
                            (i, p) -> Animations.LONGSWORD_GUARD_HIT
                    ).addGuardBreakMotion(DTWeaponCategories.DT_TACHI,
                            (i, p) -> Animations.BIPED_COMMON_NEUTRALIZED)
                    .addAdvancedGuardMotion(DTWeaponCategories.DT_TACHI,
                            (i, p) -> List.of(
                                    Animations.LONGSWORD_GUARD_ACTIVE_HIT1,
                                    Animations.LONGSWORD_GUARD_ACTIVE_HIT2,
                                    Animations.SWORD_GUARD_ACTIVE_HIT2
                            ));
        }
    }
    @SubscribeEvent
    public static void onSwordSkillCreate(SkillBuildEvent.ModRegistryWorker.SkillCreateEvent<SwordmasterSkill.Builder> event) {
        if (event.getRegistryName().equals(ResourceLocation.fromNamespaceAndPath("epicfight","swordmaster"))) {
            SwordmasterSkill.Builder builder = event.getSkillBuilder();

            builder.addAvailableWeaponCategory(DTWeaponCategories.DT_TACHI);


        }
    }
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onIconCreate(WeaponCategoryIconRegisterEvent icon) {

        icon.registerCategory(DTWeaponCategories.DT_TACHI,new ItemStack(EpicFightItems.IRON_TACHI.get()));
    }

}
