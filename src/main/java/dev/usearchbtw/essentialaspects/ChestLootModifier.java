package dev.usearchbtw.essentialaspects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

public class ChestLootModifier extends LootModifier {
    
    // Este Codec nos permite leer qué encantamiento queremos inyectar directamente desde el JSON
    public static final Codec<ChestLootModifier> CODEC = RecordCodecBuilder.create(inst ->
            codecStart(inst)
            .and(BuiltInRegistries.ENCHANTMENT.byNameCodec().fieldOf("enchantment").forGetter(m -> m.enchantment))
            .apply(inst, ChestLootModifier::new)
    );

    private final Enchantment enchantment;

    public ChestLootModifier(LootItemCondition[] conditionsIn, Enchantment enchantment) {
        super(conditionsIn);
        this.enchantment = enchantment;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // Creamos el libro, le ponemos el encantamiento del JSON y lo añadimos al cofre
        ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
        EnchantedBookItem.addEnchantment(book, new EnchantmentInstance(this.enchantment, 1));
        generatedLoot.add(book); 
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}