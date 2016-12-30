package uk.co.hexeption.swifter.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.hexeption.swifter.ModInfo;
import uk.co.hexeption.swifter.blocks.BlockBase;
import uk.co.hexeption.swifter.blocks.IBlockRenderer;
import uk.co.hexeption.swifter.items.IItemRenderer;
import uk.co.hexeption.swifter.items.ItemBase;

import java.util.Locale;

/**
 * Created by Hexeption on 30/12/2016.
 */
public class RegistrationHelper {

    public static Item registerItem(Class<? extends Item> itemclass) {

        Item item = null;
        String internalName = "";

        try {
            item = itemclass.getConstructor().newInstance();

            //TODO: ItemName

            if (item instanceof ItemBase) {
                internalName = ((ItemBase) item).getInternalName();
            }

            if (!internalName.equals(internalName.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(String.format("Unlocalized names needs to bee all lowercase! Item: %s", internalName));
            }

            if (internalName.isEmpty()) {
                throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Item: %s", internalName));
            }

            item.setRegistryName(ModInfo.MOD_ID, internalName);
            item.setUnlocalizedName(internalName);

            GameRegistry.register(item);

            if (item instanceof IItemRenderer && Platform.isClient()) {
                ((IItemRenderer) item).registerItemRenderer();
            }

            LogHelper.info(String.format("Registered item (%s)", itemclass.getCanonicalName()));
        } catch (Exception e) {
            LogHelper.fatal(String.format("Fatal error while registering item (%s)", itemclass.getCanonicalName()));
            e.printStackTrace();
        }

        return item;
    }

    public static Block registerBlock(Class<? extends BlockBase> blockClass, Class<? extends ItemBlock> itemBlockClass) {

        Block block = null;
        ItemBlock itemBlock;
        String internalName = "";

        try {
            block = blockClass.getConstructor().newInstance();
            itemBlock = itemBlockClass.getConstructor(Block.class).newInstance(block);
            internalName = ((BlockBase) block).getInternalName();

            if (!internalName.equals(internalName.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(String.format("Unlocalized names needs to bee all lowercase! Block: %s", internalName));
            }

            if (internalName.isEmpty()) {
                throw new IllegalArgumentException(String.format("Unlocalized name cannot be blank! Block: %s", blockClass.getCanonicalName()));
            }

            block.setRegistryName(ModInfo.MOD_ID, internalName);
            block.setUnlocalizedName(internalName);
            itemBlock.setRegistryName(block.getRegistryName());

            GameRegistry.register(block);
            GameRegistry.register(itemBlock);

            if (block instanceof IBlockRenderer && Platform.isClient()) {
                ((IBlockRenderer) block).registerBlockRenderer();
                ((IBlockRenderer) block).registerBlockItemRenderer();
            }

            LogHelper.info(String.format("Registered Block (%s)", blockClass.getCanonicalName()));
        } catch (Exception e) {
            LogHelper.fatal(String.format("Fatal error while registering block (%s)", blockClass.getCanonicalName()));
            e.printStackTrace();
        }

        return block;
    }
}
