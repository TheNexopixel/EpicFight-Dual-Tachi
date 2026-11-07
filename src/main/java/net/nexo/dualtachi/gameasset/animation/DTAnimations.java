package net.nexo.dualtachi.gameasset.animation;

import net.minecraft.world.InteractionHand;
import reascer.wom.animation.attacks.BasicMultipleAttackAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.world.damagesource.StunType;

import java.sql.Time;

public class DTAnimations {

    public static AnimationManager.AnimationAccessor<StaticAnimation> DUAL_TACHI_IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> DUAL_TACHI_WALK;
    public static AnimationManager.AnimationAccessor<StaticAnimation> DUAL_TACHI_RUN;

    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_TACHI_ATTACK1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_TACHI_ATTACK2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> DUAL_TACHI_ATTACK3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_ATTACK4;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DUAL_TACHI_DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> DUAL_TACHI_AIRSLASH;

    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_SKILL1;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_SKILL2;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_SKILL3;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_SKILL4;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_AIRSLASH_SKILL;
    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_DASH_SKILL;

    public static AnimationManager.AnimationAccessor<AttackAnimation> DUAL_TACHI_SHADOW_SLASH;

    public static void build(AnimationManager.AnimationBuilder builder) {
        Armatures.ArmatureAccessor<HumanoidArmature> biped = Armatures.BIPED;

        DUAL_TACHI_IDLE = builder.nextAccessor("biped/living/dual_tachi_idle", ac ->
                new StaticAnimation(0.12F, true, ac, biped));

        DUAL_TACHI_WALK = builder.nextAccessor("biped/living/dual_tachi_walk", ac ->
                new StaticAnimation(0.12F, true, ac, biped));

        DUAL_TACHI_RUN = builder.nextAccessor("biped/living/dual_tachi_run", ac ->
                new StaticAnimation(0.12F, true, ac, biped));


        DUAL_TACHI_ATTACK1 = builder.nextAccessor("biped/combat/dual_tachi_attack1", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.20f, 0.21f, 0.4f, 1.2f, 0.5f, InteractionHand.MAIN_HAND, biped.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.6f, 0.20f, 0.7f, 0.8f, 1.2f, 0.8f, InteractionHand.MAIN_HAND, biped.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                        ,

                        new AttackAnimation.Phase(0.8f, 0.2f, 0.8f, 0.9f, 0.95f, 5.51f, InteractionHand.OFF_HAND, biped.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));

        DUAL_TACHI_ATTACK2 = builder.nextAccessor("biped/combat/dual_tachi_attack2", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.20f, 0.37f, 0.47f, 0.95f, 0.7f, InteractionHand.MAIN_HAND, biped.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,

                        new AttackAnimation.Phase(0.7f, 0.2f, 0.7f, 0.82f, 0.95f, 35.51f, InteractionHand.OFF_HAND, biped.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                                .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.adder(1F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));

        DUAL_TACHI_ATTACK3 = builder.nextAccessor("biped/combat/dual_tachi_attack3", (accessor) ->
                new BasicAttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.20f, 0.32f, 0.45f, 1.2f, 0.5f, InteractionHand.MAIN_HAND, biped.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.5f, 0.20f, 0.54f, 0.7f, 1.2f, 0.8f, InteractionHand.MAIN_HAND, biped.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                        ,

                        new AttackAnimation.Phase(0.8f, 0.2f, 0.85f, 0.95f, 0.95f, 5.51f, InteractionHand.OFF_HAND, biped.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));

        DUAL_TACHI_ATTACK4 = builder.nextAccessor("biped/combat/dual_tachi_attack4", (accessor) ->
                new AttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.2f, 0.45f, 0.7f, 1.2f, 3.51f,
                                InteractionHand.MAIN_HAND,AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(0F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL,true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.3f,1.1f))
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true)
        );
        DUAL_TACHI_DASH = builder.nextAccessor("biped/combat/dual_tachi_dash", (accessor) ->
                new DashAttackAnimation(0.12F, 0.21F, 0.65F, 0.77F, 1.1F, null, biped.get().toolR, accessor, biped)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));

        DUAL_TACHI_DASH_SKILL = builder.nextAccessor("biped/skill/dual_tachi_dash_skill", (accessor) ->
                new AttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.2f, 0.32f, 0.44f, 0.6f, 3.51f,
                                InteractionHand.MAIN_HAND,AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.28F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.RESET_PLAYER_COMBO_COUNTER,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true)
        );

        DUAL_TACHI_AIRSLASH = builder.nextAccessor("biped/combat/dual_tachi_airslash", (accessor) ->
                new AirSlashAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.2f, 0.47f, 0.6f, 1.2f, 3.51f,
                                InteractionHand.MAIN_HAND,AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                               // .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                       // .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL,true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0f,0.4f))
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true)
        );

        DUAL_TACHI_AIRSLASH_SKILL = builder.nextAccessor("biped/skill/dual_tachi_airslash_skill", (accessor) ->
                new AttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.2f, 0.42f, 0.52f, 0.6f, 3.51f,
                                InteractionHand.MAIN_HAND,AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.28F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.RESET_PLAYER_COMBO_COUNTER,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true)
        );

        DUAL_TACHI_SKILL1 = builder.nextAccessor("biped/skill/dual_tachi_skill1", (accessor) ->
                new AttackAnimation(0.12F, 0.21F, 0.37F, 0.55F, 0.62F, null, biped.get().toolR, accessor, biped)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.5F))
                        .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                       // .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                        .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.5F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.RESET_PLAYER_COMBO_COUNTER,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));



        DUAL_TACHI_SKILL2 = builder.nextAccessor("biped/skill/dual_tachi_skill2", (accessor) ->
                new AttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.2f, 0.37f, 0.5f, 0.5f, 3.51f,
                                InteractionHand.MAIN_HAND,AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolR, null),
                                AttackAnimation.JointColliderPair.of(Armatures.BIPED.get().toolL, null))
                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.8F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.28F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.RESET_PLAYER_COMBO_COUNTER,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true)
        );

        DUAL_TACHI_SKILL3 = builder.nextAccessor("biped/skill/dual_tachi_skill3", (accessor) ->
                new AttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.10f, 0.15f, 0.25f, 1.2f, 0.25f, InteractionHand.OFF_HAND, biped.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.25f, 0.10f, 0.32f, 0.42f, 1.2f, 0.5f, InteractionHand.OFF_HAND, biped.get().toolL, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.5f, 0.10f, 0.52f, 0.6f, 1.2f, 0.9f, InteractionHand.MAIN_HAND, biped.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                        ,

                        new AttackAnimation.Phase(0.9f, 0.2f, 0.9f, 1.0f, 1.05f, 5.51f, InteractionHand.MAIN_HAND, biped.get().toolR, null)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.2F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.RESET_PLAYER_COMBO_COUNTER,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));

        DUAL_TACHI_SHADOW_SLASH = builder.nextAccessor("biped/skill/shadow_slash", (accessor) ->
                new AttackAnimation(0.12F, accessor, biped,
                        new AttackAnimation.Phase(0.0f, 0.10f, 0.35f, 0.45f, 1.72f, 0.45f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.45f, 0.10f, 0.45f, 0.55f, 1.72f, 0.55f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.55f, 0.10f, 0.55f, 0.65f, 1.7f, 0.65f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.65f, 0.10f, 0.65f, 0.75f, 1.7f, 0.75f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.75f, 0.10f, 0.75f, 0.85f, 1.7f, 0.85f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.85f, 0.10f, 0.85f, 0.95f, 1.7f, 0.95f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(0.95f, 0.10f, 0.95f, 1.05f, 1.7f, 1.05f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(1.05f, 0.10f, 1.05f, 1.15f, 1.7f, 1.15f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,
                        new AttackAnimation.Phase(1.15f, 0.10f, 1.15f, 1.25f, 1.7f, 1.25f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.4F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(10F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.HOLD)
                        ,


                        new AttackAnimation.Phase(1.2f, 0.2f, 1.5f, 1.65f, 1.7f, 5.51f, InteractionHand.MAIN_HAND, biped.get().rootJoint, DTCollider.TACHI_ULTIMATE)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.3F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE,StunType.LONG)
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.adder(15F))
                                .addProperty(AnimationProperty.AttackPhaseProperty.PARTICLE, EpicFightParticles.BLADE_RUSH_SKILL)
                                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_SHARP.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.ARMOR_NEGATION_MODIFIER, ValueModifier.adder(30F))
                )

                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.6F)
                        .addProperty(AnimationProperty.AttackAnimationProperty.MOVE_VERTICAL,true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE,true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.3f,2.0f))
                        .addProperty(AnimationProperty.AttackAnimationProperty.RESET_PLAYER_COMBO_COUNTER,false)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));



    }

}
