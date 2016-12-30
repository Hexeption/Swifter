package uk.co.hexeption.swifter.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Hexeption on 30/12/2016.
 */
public interface IItemRenderer {

    @SideOnly(Side.CLIENT)
    void registerItemRenderer();

}
