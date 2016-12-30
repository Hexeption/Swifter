package uk.co.hexeption.swifter.items;

import net.minecraft.item.Item;
import uk.co.hexeption.swifter.items.ores.ItemOreIngot;
import uk.co.hexeption.swifter.utils.RegistrationHelper;

/**
 * Created by Hexeption on 29/12/2016.
 */
public enum Items {

    ITEM_ORE_INGOT(ItemOreIngot.class);

    private final Class<? extends Item> itemClass;

    private Item item;

    Items(Class<? extends Item> itemClass) {

        this.itemClass = itemClass;
    }

    public static void registerItems() {

        for (Items i : Items.values()) {
            i.registerItem();
        }
    }

    private void registerItem() {

        item = RegistrationHelper.registerItem(itemClass);
    }
}
