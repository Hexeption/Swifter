package uk.co.hexeption.swifter.blocks;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Hexeption on 30/12/2016.
 */
@SideOnly(Side.CLIENT)
public interface IBlockRenderer {

    void registerBlockRenderer();

    void registerBlockItemRenderer();

}
