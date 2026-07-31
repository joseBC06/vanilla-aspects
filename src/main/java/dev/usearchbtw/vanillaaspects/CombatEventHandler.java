package dev.usearchbtw.vanillaaspects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingKnockBackEvent;

@Mod.EventBusSubscriber(modid = VanillaAspects.MODID)
public class CombatEventHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        // Verificamos que el atacante sea un jugador
        if (event.getSource().getEntity() instanceof Player player && event.getSource().getDirectEntity() == player) {
            LivingEntity target = event.getEntity();
            
            // Obtenemos los niveles de los encantamientos
            int venomLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VENOMOUS_ASPECT.get(), player.getMainHandItem());
            int witherLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.WITHER_ASPECT.get(), player.getMainHandItem());
            int lifestealLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.LIFESTEAL.get(), player.getMainHandItem());

            // 1. Lógica de Venomous Aspect (No afecta a no-muertos)
            if (venomLevel > 0 && target.getMobType() != MobType.UNDEAD) {
                int duration = (venomLevel == 1) ? 120 : 240; // 6 o 12 segundos
                target.addEffect(new MobEffectInstance(MobEffects.POISON, duration, 0));
            }

            // 2. Lógica de Wither Aspect 
            if (witherLevel > 0) {
                int duration = (witherLevel == 1) ? 60 : 120; // 3 o 6 segundos
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, duration, 0));
            }

            // 3. Lógica de Lifesteal (Cura un 10% del daño por nivel)
            if (lifestealLevel > 0) {
                float healAmount = event.getAmount() * (0.1f * lifestealLevel);
                player.heal(healAmount);
            }
        }
    }

    @SubscribeEvent
    public static void onKnockback(LivingKnockBackEvent event) {
        // Interceptamos la física antes de que el mob salga volando
        if (event.getEntity().getLastHurtByMob() instanceof Player player) {
            int heavyBladeLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.HEAVY_BLADE.get(), player.getMainHandItem());
            
            if (heavyBladeLevel == 1) {
                // Reduce el empuje a la mitad
                event.setStrength(event.getStrength() * 0.5f);
            } else if (heavyBladeLevel >= 2) {
                // Anula el empuje por completo
                event.setCanceled(true); 
            }
        }
    }
}