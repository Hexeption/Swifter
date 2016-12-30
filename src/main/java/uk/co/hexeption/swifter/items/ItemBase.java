package uk.co.hexeption.swifter.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.hexeption.swifter.ModInfo;

/**
 * Created by Hexeption on 30/12/2016.
 */
public class ItemBase extends Item implements IItemRenderer{

    protected String resourcePath = "";

    protected String internalName = "";

    public ItemBase(String resourcePath) {

        this.resourcePath = resourcePath;
    }

    @Override
    public String getUnlocalizedName() {

        String itemName = getUnwrappedUnlocalizedName(super.getUnlocalizedName());

        String test = String.format("item.%s.%s", ModInfo.MOD_ID, itemName);
        return test;
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {

        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public String getInternalName() {

        return internalName;
    }

    public void setInternalName(String internalName) {

        this.internalName = internalName;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerItemRenderer() {
        final String resourcePath = String.format("%s:%s", ModInfo.MOD_ID, this.resourcePath);
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(resourcePath, "inventory"));

    }
}
