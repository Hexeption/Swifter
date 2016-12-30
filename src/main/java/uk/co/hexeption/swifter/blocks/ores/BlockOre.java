package uk.co.hexeption.swifter.blocks.ores;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import uk.co.hexeption.swifter.SwifterCreativeTabs;
import uk.co.hexeption.swifter.blocks.BlockBase;
import uk.co.hexeption.swifter.items.ores.EnumOreType;
import uk.co.hexeption.swifter.items.ores.EnumOres;

/**
 * Created by Hexeption on 30/12/2016.
 */
public class BlockOre extends BlockBase {

    public static PropertyEnum MATERIAL = PropertyEnum.create("material", EnumOres.class);

    public BlockOre() {

        super(Material.ROCK, "ores/ore");
        this.setDefaultState(this.blockState.getBaseState().withProperty(MATERIAL, EnumOres.byMeta(0)));
        this.setCreativeTab(SwifterCreativeTabs.MATERIALS);
        this.setInternalName("ore");
        this.setHarvestLevel("pickaxe", 0);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {

        return this.getDefaultState().withProperty(MATERIAL, EnumOres.byMeta(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {

        EnumOres material = (EnumOres) state.getValue(MATERIAL);
        return (material.getMeta());
    }

    @Override
    protected BlockStateContainer createBlockState() {

        return new BlockStateContainer(this, MATERIAL);
    }

    @Override
    public int damageDropped(IBlockState state) {

        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {

        for (int i = 0; i < EnumOres.values().length; i++) {
            if (EnumOres.byMeta(i).isTypeSet(EnumOreType.ORE)) {
                list.add(new ItemStack(itemIn, 1, i));
            }
        }
    }
}
