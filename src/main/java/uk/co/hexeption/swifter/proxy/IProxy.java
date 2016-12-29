package uk.co.hexeption.swifter.proxy;

/**
 * Created by Hexeption on 29/12/2016.
 */
public interface IProxy {

    void registerBlocks();

    void registerItems();

    void registerRecipes();

    void registerOreDict();

    void registerEvents();

    void registerRenderers();

    void registerSounds();

    void registerConfiguration();
}
