package dev.usearchbtw.essentialaspects;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ScorchingTouchEnchantment extends Enchantment {

    public ScorchingTouchEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentCategory.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return 15;
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 1; // Solo tiene 1 nivel
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        if (other == Enchantments.SILK_TOUCH || other == Enchantments.BLOCK_FORTUNE) {
            return false;
        }
        return super.checkCompatibility(other);
    }
}