package dev.usearchbtw.essentialaspects;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    
    // En la 1.20.1 usamos ForgeRegistries.ENCHANTMENTS
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = 
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EssentialAspects.MODID);

    // Cambiamos DeferredHolder por RegistryObject y dejamos un solo parámetro en el diamante
    public static final RegistryObject<Enchantment> VENOMOUS_ASPECT = 
            ENCHANTMENTS.register("venomous_aspect", () -> new VenomousAspectEnchantment());

    public static final RegistryObject<Enchantment> WITHER_ASPECT = 
            ENCHANTMENTS.register("wither_aspect", () -> new WitherAspectEnchantment());

    public static final RegistryObject<Enchantment> LIFESTEAL = 
            ENCHANTMENTS.register("lifesteal", () -> new LifestealEnchantment());

    public static final RegistryObject<Enchantment> HEAVY_BLADE = 
            ENCHANTMENTS.register("heavy_blade", () -> new HeavyBladeEnchantment());

    public static final RegistryObject<Enchantment> SCORCHING_TOUCH = 
            ENCHANTMENTS.register("scorching_touch", () -> new ScorchingTouchEnchantment());
}