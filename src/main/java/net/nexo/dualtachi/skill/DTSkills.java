package net.nexo.dualtachi.skill;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nexo.dualtachi.EFDT;
import net.nexo.dualtachi.skill.weapon_innate.RagingTempestSkill;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

@Mod.EventBusSubscriber(
        modid = EFDT.MODID,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class DTSkills {

    public static Skill RAGING_TEMPEST;

    @SubscribeEvent
    public static void buildSkillEvent(SkillBuildEvent build) {
        SkillBuildEvent.ModRegistryWorker modRegistry = build.createRegistryWorker(EFDT.MODID);


        RAGING_TEMPEST = modRegistry.build("raging_tempest", RagingTempestSkill::new,
                WeaponInnateSkill.createWeaponInnateBuilder()
                        .setCategory(SkillCategories.WEAPON_INNATE));

    }

}
