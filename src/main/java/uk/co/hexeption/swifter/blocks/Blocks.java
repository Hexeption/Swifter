package uk.co.hexeption.swifter.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import uk.co.hexeption.swifter.blocks.ores.BlockOre;
import uk.co.hexeption.swifter.items.ores.ItemOre;
import uk.co.hexeption.swifter.utils.RegistrationHelper;

/**
 * Created by Hexeption on 30/12/2016.
 */
public enum Blocks {

    BLOCKS_ORE(BlockOre.class, ItemOre.class);

    private final Class<? extends BlockBase> blockClass;

    private final Class<? extends ItemBlock> itemBlockClass;

    private Block block;

    Blocks(Class<? extends BlockBase> blockClass, Class<? extends ItemBlock> itemBlockClass) {

        this.blockClass = blockClass;
        this.itemBlockClass = itemBlockClass;
    }

    Blocks(Class<? extends BlockBase> blockClass) {

        this(blockClass, ItemBlock.class);
    }

    public static void registerBlocks() {

        for (Blocks blocks : Blocks.values()) {
            blocks.registerBlock();
        }
    }

    private void registerBlock() {

        block = RegistrationHelper.registerBlock(blockClass, itemBlockClass);
    }

    public ItemStack getStack() {

        return new ItemStack(block);
    }

    public ItemStack getStack(int size) {

        return new ItemStack(block, size);
    }

    public ItemStack getStack(int size, int meta) {

        return new ItemStack(block, size, meta);
    }

    public Block getBlock() {

        return block;
    }
}
