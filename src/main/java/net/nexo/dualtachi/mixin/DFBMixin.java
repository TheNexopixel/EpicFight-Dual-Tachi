package net.nexo.dualtachi.mixin;

import net.nexo.dualtachi.gameasset.animation.DTCollider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import reascer.wom.gameasset.WOMAnimations;
import reascer.wom.skill.guard.DreadFullBusterSkill;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

@Mixin(value = DreadFullBusterSkill.class, remap = false)
public class DFBMixin {
    @Inject(method = "getWindupAnimation", at = @At("HEAD"), cancellable = true)
    private void DFBWindup(CapabilityItem capabilityItem, PlayerPatch<?> playerPatch, CallbackInfoReturnable<AnimationManager.AnimationAccessor<?>> cir) {

        if (capabilityItem.getWeaponCollider() == DTCollider.TACHI) {
            cir.setReturnValue (capabilityItem.getStyle(playerPatch) == CapabilityItem.Styles.OCHS ? WOMAnimations.DUALSWORD_BUSTER_WINDUP : WOMAnimations.TACHI_BUSTER_WINDUP);
        }

    }
    @Inject(method = "getReleaseAnimataion", at = @At("HEAD"), cancellable = true)
    private void DFBRelease(CapabilityItem capabilityItem, PlayerPatch<?> playerPatch, CallbackInfoReturnable<AnimationManager.AnimationAccessor<? extends StaticAnimation>> cir) {

        if (capabilityItem.getWeaponCollider() == DTCollider.TACHI) {
            cir.setReturnValue (capabilityItem.getStyle(playerPatch) == CapabilityItem.Styles.OCHS ? WOMAnimations.DUALSWORD_BUSTER_RELEASE : WOMAnimations.TACHI_BUSTER_RELEASE);
        }
    }
}
