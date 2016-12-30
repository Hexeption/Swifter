package uk.co.hexeption.swifter.items.ores;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hexeption on 30/12/2016.
 */
public enum EnumOres implements IStringSerializable {
    COPPER("Copper", 0, EnumOreType.ORE, EnumOreType.BLOCK, EnumOreType.DUST, EnumOreType.INGOT, EnumOreType.NUGGETS),
    TIN("Tin", 1, EnumOreType.ORE, EnumOreType.BLOCK, EnumOreType.DUST, EnumOreType.INGOT, EnumOreType.NUGGETS),
    LEAD("Lead", 2, EnumOreType.ORE, EnumOreType.BLOCK, EnumOreType.DUST, EnumOreType.INGOT, EnumOreType.NUGGETS),
    STEEL("Steel", 3, EnumOreType.ORE, EnumOreType.BLOCK, EnumOreType.DUST, EnumOreType.INGOT, EnumOreType.NUGGETS),;


    private static final EnumOres[] META = new EnumOres[values().length];

    static {
        for (EnumOres ore : values()) {
            META[ore.getMeta()] = ore;
        }
    }

    private final String name;

    private final int meta;

    private final EnumOreType[] enumOreTypes;

    EnumOres(String name, int meta, EnumOreType... oreTypes) {

        this.name = name;
        this.meta = meta;
        this.enumOreTypes = oreTypes;
    }

    public static EnumOres byMeta(int meta) {

        if (meta < 0 || meta >= META.length) {
            meta = 0;
        }

        return META[meta];
    }

    public static List<EnumOres> byType(EnumOreType type) {

        List<EnumOres> result = new ArrayList<>();

        for (EnumOres ore : values()) {
            if (ore.isTypeSet(type)) {
                result.add(ore);
            }
        }

        return result;
    }

    public boolean isTypeSet(EnumOreType enumOreType) {

        return Arrays.asList(enumOreTypes).contains(enumOreType);
    }

    public String getUnlocalizedName() {

        return this.name.toLowerCase();
    }

    @Override
    public String getName() {

        return this.name.toLowerCase();
    }

    public String getOreName() {

        return this.name;
    }

    public String toString() {

        return getName();
    }

    public int getMeta() {

        return this.meta;
    }
}

