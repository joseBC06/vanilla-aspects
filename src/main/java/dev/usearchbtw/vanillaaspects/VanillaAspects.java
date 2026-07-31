package dev.usearchbtw.vanillaaspects;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(VanillaAspects.MODID)
public class VanillaAspects {

    public static final String MODID = "vanilla_aspects";

    public VanillaAspects(IEventBus modEventBus) {
        
        // Conectamos nuestro registro de encantamientos al bus del juego
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}