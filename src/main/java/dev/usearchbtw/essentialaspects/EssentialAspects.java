package dev.usearchbtw.essentialaspects;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(EssentialAspects.MODID)
public class EssentialAspects {

    public static final String MODID = "essential_aspects";

    public EssentialAspects(IEventBus modEventBus) {
        
        // Conectamos nuestro registro de encantamientos al bus del juego
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}