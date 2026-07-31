package dev.usearchbtw.vanillaaspects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class ScorchingTouchModifier extends LootModifier {
    
    // Usamos Codec normal y RecordCodecBuilder.create para la 1.20.4
    public static final Codec<ScorchingTouchModifier> CODEC = RecordCodecBuilder.create(inst ->
            codecStart(inst).apply(inst, ScorchingTouchModifier::new)
    );

    public ScorchingTouchModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ObjectArrayList<ItemStack> newLoot = new ObjectArrayList<>();
        
        for (ItemStack stack : generatedLoot) {
            var recipe = context.getLevel().getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel());
            
            if (recipe.isPresent()) {
                ItemStack smeltedResult = recipe.get().value().getResultItem(context.getLevel().registryAccess()).copy();
                smeltedResult.setCount(stack.getCount());
                newLoot.add(smeltedResult);
            } else {
                newLoot.add(stack);
            }
        }
        return newLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}