package net.nexo.dualtachi.gameasset.animation;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.resources.ResourceLocation;
import net.nexo.dualtachi.EFDT;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;

public class DTCollider {
    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation rl, Collider collider) {
        if (PRESETS.containsKey(rl)) {
            throw new IllegalStateException("Collider named " + rl + " already registered.");
        }
        PRESETS.put(rl, collider);

        return collider;
    }

    public static final Collider TACHI = registerCollider(ResourceLocation.fromNamespaceAndPath(EFDT.MODID,"tachi")
            ,new MultiOBBCollider(4, 0.4D, 0.4D, 1.23D, 0D, 0.0D, -1.00D));

    public static final Collider TACHI_ULTIMATE = registerCollider(ResourceLocation.fromNamespaceAndPath(EFDT.MODID,"tachi_ult"),
            new MultiOBBCollider(1, 6.0D, 2.9D, 6.0D, 0D, 1.5D, 0.0D));

}
