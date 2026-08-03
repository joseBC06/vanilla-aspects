package dev.usearchbtw.essentialaspects;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {

    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, EssentialAspects.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> SCORCHING_TOUCH =
            LOOT_MODIFIER_SERIALIZERS.register("scorching_touch", () -> ScorchingTouchModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> CHEST_LOOT =
            LOOT_MODIFIER_SERIALIZERS.register("chest_loot", () -> ChestLootModifier.CODEC);
}