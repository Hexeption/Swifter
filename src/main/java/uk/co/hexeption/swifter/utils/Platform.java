package uk.co.hexeption.swifter.utils;

import net.minecraft.block.properties.IProperty;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.util.Map;

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

    public static String getPropertyString(Map<IProperty<?>, Comparable<?>> values, String... extraArgs) {

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<IProperty<?>, Comparable<?>> entry : values.entrySet()) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(",");
            }

            IProperty<?> iProperty = entry.getKey();
            stringBuilder.append(iProperty.getName());
            stringBuilder.append("=");
            stringBuilder.append(getPropertyName(iProperty, entry.getValue()));
        }

        if (stringBuilder.length() == 0) {
            stringBuilder.append("inventory");
        }

        for (String args : extraArgs) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(args);
        }

        return stringBuilder.toString();
    }

    private static <T extends Comparable<T>> String getPropertyName(IProperty<T> iProperty, Comparable<?> value) {

        return iProperty.getName((T) value);
    }


}
