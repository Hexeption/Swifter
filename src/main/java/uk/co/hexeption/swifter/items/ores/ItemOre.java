package uk.co.hexeption.swifter.items.ores;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Hexeption on 30/12/2016.
 */
public class ItemOre extends ItemBlock {

    public ItemOre(Block block) {

        super(block);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
    }

    @Override
    public int getMetadata(int damage) {

        return damage;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        String name = super.getUnlocalizedName();
        String oreName = EnumOres.byMeta(stack.getItemDamage()).getUnlocalizedName();
        return name + "." + oreName;
    }
}
