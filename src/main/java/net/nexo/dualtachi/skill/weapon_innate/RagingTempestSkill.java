package net.nexo.dualtachi.skill.weapon_innate;

import com.google.common.collect.Maps;
import net.minecraft.network.FriendlyByteBuf;
import net.nexo.dualtachi.gameasset.animation.DTAnimations;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

import java.util.Map;
import java.util.Objects;

public class RagingTempestSkill extends WeaponInnateSkill {



    private final Map<AnimationManager.AnimationAccessor<? extends StaticAnimation>, AnimationManager.AnimationAccessor<? extends AttackAnimation>> comboAnimation = Maps.newHashMap();

    public RagingTempestSkill(SkillBuilder<? extends WeaponInnateSkill> builder) {
        super(builder);
    }
    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
    }

    @Override
    public void onRemoved(SkillContainer container) {
    }
    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args) {
        PlayerPatch<?> player = container.getServerExecutor();

        AssetAccessor<? extends DynamicAnimation> animation =
                Objects.requireNonNull(
                        player.getAnimator().getPlayerFor(null)
                ).getAnimation();

        if (player.getOriginal().isShiftKeyDown()
                && (player.getOriginal().isCreative()
                || container.getStack() >= 4)) {

            player.playAnimationSynchronized(
                    DTAnimations.DUAL_TACHI_SHADOW_SLASH,
                    0.0F
            );

            if (!player.getOriginal().isCreative()) {
                Skill.setSkillStackSynchronize(container,0);
            }

            return;
        }
        if (this.comboAnimation.containsKey(animation)) {
            player.playAnimationSynchronized(
                    this.comboAnimation.get(animation),
                    0.0F
            );

            super.executeOnServer(container, args);
        }
    }
    @Override
    public boolean checkExecuteCondition(SkillContainer container) {
        PlayerPatch<?> player = container.getExecutor();

        AssetAccessor<? extends DynamicAnimation> animation =
                Objects.requireNonNull(
                        player.getAnimator().getPlayerFor(null)
                ).getAnimation();

        if (player.getOriginal().isShiftKeyDown()
                && (player.getOriginal().isCreative()
                || container.getStack() >= 4)) {
            return player.getEntityState().canUseSkill();
        }
        return this.comboAnimation.containsKey(animation)
                && player.getEntityState().canUseSkill()
                && player.getEntityState().inaction();
    }
    @Override
    public WeaponInnateSkill registerPropertiesToAnimation() {
        this.comboAnimation.clear();

        this.comboAnimation.put(
                DTAnimations.DUAL_TACHI_ATTACK1,
                DTAnimations.DUAL_TACHI_SKILL1
        );

        this.comboAnimation.put(
                DTAnimations.DUAL_TACHI_ATTACK2,
                DTAnimations.DUAL_TACHI_SKILL2
        );
        this.comboAnimation.put(
                DTAnimations.DUAL_TACHI_ATTACK3,
                DTAnimations.DUAL_TACHI_SKILL3
        );
        this.comboAnimation.put(
                DTAnimations.DUAL_TACHI_DASH,
                DTAnimations.DUAL_TACHI_DASH_SKILL
        );
        this.comboAnimation.put(
                DTAnimations.DUAL_TACHI_AIRSLASH,
                DTAnimations.DUAL_TACHI_AIRSLASH_SKILL
        );

        return this;
    }


}
