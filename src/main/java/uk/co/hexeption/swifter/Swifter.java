package uk.co.hexeption.swifter;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
        modid = Swifter.MOD_ID,
        name = Swifter.MOD_NAME,
        version = Swifter.VERSION
)
public class Swifter {

    public static final String MOD_ID = "swifter";

    public static final String MOD_NAME = "Swifter";

    public static final String VERSION = "1.0-SNAPSHOT";

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
