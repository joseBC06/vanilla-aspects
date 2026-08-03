package dev.usearchbtw.essentialaspects;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod; // Cambiado a minecraftforge
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;

@Mod.EventBusSubscriber(modid = EssentialAspects.MODID)
public class CombatEventHandler {

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof Player player && event.getSource().getDirectEntity() == player) {
            LivingEntity target = event.getEntity();
            
            int venomLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.VENOMOUS_ASPECT.get(), player.getMainHandItem());
            int witherLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.WITHER_ASPECT.get(), player.getMainHandItem());
            int lifestealLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.LIFESTEAL.get(), player.getMainHandItem());

            if (venomLevel > 0 && target.getMobType() != MobType.UNDEAD) {
                int duration = (venomLevel == 1) ? 120 : 240;
                target.addEffect(new MobEffectInstance(MobEffects.POISON, duration, 0));
            }

            if (witherLevel > 0) {
                int duration = (witherLevel == 1) ? 60 : 120;
                target.addEffect(new MobEffectInstance(MobEffects.WITHER, duration, 0));
            }

            if (lifestealLevel > 0) {
                float healAmount = event.getAmount() * (0.1f * lifestealLevel);
                player.heal(healAmount);
            }
        }
    }

    @SubscribeEvent
    public static void onKnockback(LivingKnockBackEvent event) {
        if (event.getEntity().getLastHurtByMob() instanceof Player player) {
            int heavyBladeLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.HEAVY_BLADE.get(), player.getMainHandItem());
            
            if (heavyBladeLevel == 1) {
                event.setStrength(event.getStrength() * 0.5f);
            } else if (heavyBladeLevel >= 2) {
                event.setCanceled(true); 
            }
        }
    }
}