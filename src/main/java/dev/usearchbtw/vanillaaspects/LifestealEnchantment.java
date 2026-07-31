package dev.usearchbtw.vanillaaspects;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class LifestealEnchantment extends Enchantment {

    public LifestealEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        if (other == Enchantments.FIRE_ASPECT || 
            other instanceof VenomousAspectEnchantment || 
            other instanceof WitherAspectEnchantment) {
            return false;
        }
        return super.checkCompatibility(other);
    }
}