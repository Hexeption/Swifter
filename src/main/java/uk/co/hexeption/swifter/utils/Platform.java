package uk.co.hexeption.swifter.utils;

import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by Hexeption on 30/12/2016.
 */
public class Platform {

    /**
     * Checks if the code is running on client side
     *
     * @return
     */
    public static boolean isClient() {

        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    /**
     * Checks if the code is running on server side
     *
     * @return
     */
    public static boolean isServer() {

        return FMLCommonHandler.instance().getEffectiveSide().isServer();
    }

}
