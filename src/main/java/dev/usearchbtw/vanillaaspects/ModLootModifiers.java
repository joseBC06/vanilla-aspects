package dev.usearchbtw.vanillaaspects;

import com.mojang.serialization.Codec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModLootModifiers {
    
    // En la 1.20.4 el registro exige Codec, no MapCodec
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VanillaAspects.MODID);

    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<ScorchingTouchModifier>> SCORCHING_TOUCH =
            LOOT_MODIFIER_SERIALIZERS.register("scorching_touch", () -> ScorchingTouchModifier.CODEC);

    public static final DeferredHolder<Codec<? extends IGlobalLootModifier>, Codec<ChestLootModifier>> CHEST_LOOT =
        LOOT_MODIFIER_SERIALIZERS.register("chest_loot", () -> ChestLootModifier.CODEC);
}