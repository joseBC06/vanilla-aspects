package dev.usearchbtw.vanillaaspects;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class HeavyBladeEnchantment extends Enchantment {

    public HeavyBladeEnchantment() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return 5 + 20 * (level - 1);
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
        // Totalmente incompatible con el empuje normal
        if (other == Enchantments.KNOCKBACK) {
            return false;
        }
        return super.checkCompatibility(other);
    }
}