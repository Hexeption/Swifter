package uk.co.hexeption.swifter;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Hexeption on 30/12/2016.
 */
@SideOnly(Side.CLIENT)
public class SwifterCreativeTabs {

    public static final CreativeTabs GENERAL = new CreativeTabs(ModInfo.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {

            return Item.getItemFromBlock(Blocks.STONE).getDefaultInstance();
        }

        @Override
        public String getTabLabel() {

            return ModInfo.MOD_ID + ".general";
        }
    };

    public static final CreativeTabs MATERIALS = new CreativeTabs(ModInfo.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {

            return uk.co.hexeption.swifter.items.Items.ITEM_ORE_INGOT.getStack();
        }

        @Override
        public String getTabLabel() {

            return ModInfo.MOD_ID + ".materials";
        }
    };

    public static final CreativeTabs FLUIDS = new CreativeTabs(ModInfo.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {

            return Items.BUCKET.getDefaultInstance();
        }

        @Override
        public String getTabLabel() {

            return ModInfo.MOD_ID + ".fluids";
        }
    };


}
