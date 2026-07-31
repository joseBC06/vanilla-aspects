package dev.usearchbtw.vanillaaspects;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModEnchantments {
    
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = 
            DeferredRegister.create(Registries.ENCHANTMENT, VanillaAspects.MODID);

    public static final DeferredHolder<Enchantment, VenomousAspectEnchantment> VENOMOUS_ASPECT = 
            ENCHANTMENTS.register("venomous_aspect", () -> new VenomousAspectEnchantment());

    public static final DeferredHolder<Enchantment, WitherAspectEnchantment> WITHER_ASPECT = 
            ENCHANTMENTS.register("wither_aspect", () -> new WitherAspectEnchantment());

    public static final DeferredHolder<Enchantment, LifestealEnchantment> LIFESTEAL = 
            ENCHANTMENTS.register("lifesteal", () -> new LifestealEnchantment());

    public static final DeferredHolder<Enchantment, HeavyBladeEnchantment> HEAVY_BLADE = 
            ENCHANTMENTS.register("heavy_blade", () -> new HeavyBladeEnchantment());

    public static final DeferredHolder<Enchantment, ScorchingTouchEnchantment> SCORCHING_TOUCH = 
            ENCHANTMENTS.register("scorching_touch", () -> new ScorchingTouchEnchantment());
}