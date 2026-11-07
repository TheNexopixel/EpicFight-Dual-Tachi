package net.nexo.dualtachi.events;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nexo.dualtachi.EFDT;
import net.nexo.dualtachi.gameasset.animation.AnimationBuilder;
import yesman.epicfight.api.animation.AnimationManager;

@Mod.EventBusSubscriber(modid = EFDT.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AnimationBuildEvent {
    @SubscribeEvent
    public static void registerAnimation(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(EFDT.MODID, AnimationBuilder::BobtheAninimationBuilder);
    }
}
