package dev.usearchbtw.essentialaspects;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext; // <-- Importación nueva necesaria en Forge clásico

@Mod(EssentialAspects.MODID)
public class EssentialAspects {

    public static final String MODID = "essential_aspects";

    // En Forge clásico, el constructor NO lleva parámetros
    public EssentialAspects() {
        
        // Obtenemos el bus de eventos manualmente
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Conectamos nuestro registro de encantamientos al bus del juego
        ModEnchantments.ENCHANTMENTS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
        
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }
}