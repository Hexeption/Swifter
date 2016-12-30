package uk.co.hexeption.swifter.proxy;

import uk.co.hexeption.swifter.items.Items;

/**
 * Created by Hexeption on 29/12/2016.
 */
public class CommonProxy implements IProxy {

    @Override
    public void registerBlocks() {

    }

    @Override
    public void registerItems() {

        Items.registerItems();

    }

    @Override
    public void registerRecipes() {

    }

    @Override
    public void registerOreDict() {

    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void registerRenderers() {

    }

    @Override
    public void registerSounds() {

    }

    @Override
    public void registerConfiguration() {

    }
}
