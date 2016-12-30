package uk.co.hexeption.swifter.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.hexeption.swifter.ModInfo;
import uk.co.hexeption.swifter.utils.Platform;

/**
 * Created by Hexeption on 30/12/2016.
 */
public class BlockBase extends Block implements IBlockRenderer {

    protected String resourcePath = "";

    protected String internalName = "";

    public BlockBase(Material blockMaterialIn, String resourcePath) {

        super(blockMaterialIn);
        this.setHardness(2);
        this.setResistance(5);
        this.setHarvestLevel("pickaxe", 0);
        this.resourcePath = resourcePath;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {

        return EnumBlockRenderType.MODEL;
    }

    @Override
    public String getUnlocalizedName() {

        String itemName = getUnwrappedUnlocalizedName(super.getUnlocalizedName());

        String test = String.format("tile.%s.%s", ModInfo.MOD_ID, itemName);
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

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockRenderer() {
        final String resourcePath = String.format("%s:%s", ModInfo.MOD_ID, this.resourcePath);

        ModelLoader.setCustomStateMapper(this, new DefaultStateMapper(){

            @SideOnly(Side.CLIENT)
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

                return new ModelResourceLocation(resourcePath, getPropertyString(state.getProperties()));
            }
        });
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockItemRenderer() {
        final String resourcePath = String.format("%s:%s", ModInfo.MOD_ID, this.resourcePath);

        NonNullList<ItemStack> subBlocks = NonNullList.create();
        getSubBlocks(Item.getItemFromBlock(this), null, subBlocks);

        for(ItemStack itemStack : subBlocks){
            IBlockState blockState = this.getStateFromMeta(itemStack.getItemDamage());
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), itemStack.getItemDamage(), new ModelResourceLocation(resourcePath, Platform.getPropertyString(blockState.getProperties())));
        }

    }
}
