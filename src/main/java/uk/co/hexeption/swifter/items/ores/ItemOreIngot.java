package uk.co.hexeption.swifter.items.ores;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import uk.co.hexeption.swifter.ModInfo;
import uk.co.hexeption.swifter.SwifterCreativeTabs;
import uk.co.hexeption.swifter.items.ItemBase;

/**
 * Created by Hexeption on 30/12/2016.
 */
public class ItemOreIngot extends ItemBase {

    public ItemOreIngot() {

        super("ores/ingot");
        this.setHasSubtypes(true);
        this.setCreativeTab(SwifterCreativeTabs.MATERIALS);
        this.setInternalName("ore_ingot");
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {

        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.INGOT)) {
                subItems.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {

        String name = super.getUnlocalizedName();
        String oreName = EnumOres.byMeta(itemStack.getItemDamage()).getUnlocalizedName();
        return name + "." + oreName;
    }

    @Override
    public void registerItemRenderer() {

        for (int i = 0; i < EnumOres.values().length; i++) {
            ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(ModInfo.MOD_ID + ":ores/ingot_" + EnumOres.byMeta(i).getUnlocalizedName(), "inventory"));
        }
    }
}
