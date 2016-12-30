package uk.co.hexeption.swifter;

import com.google.common.base.Stopwatch;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import uk.co.hexeption.swifter.proxy.IProxy;
import uk.co.hexeption.swifter.utils.LogHelper;
import uk.co.hexeption.swifter.utils.OutdatedJavaException;

import java.util.concurrent.TimeUnit;

/**
 * Created by Hexeption on 29/12/2016.
 */

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION_BUILD)
public enum Swifter {

    /**
     * Mod Instance
     */

    INSTANCE;

    @Mod.InstanceFactory
    public static Swifter getInstance() {

        return INSTANCE;
    }

    /**
     * Mod Proxys
     */
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.SERVER_PROXY)
    private static IProxy proxy;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public void onFMLPreInitialization(FMLPreInitializationEvent event) {

        final Stopwatch timer = Stopwatch.createStarted();
        LogHelper.info("Pre Initialization (Started)");

        //TODO: PreInitialization

        if (!SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8)) {
            throw new OutdatedJavaException(String.format("%s requires Java 8 or newer, Please update your java", ModInfo.MOD_NAME));
        }

        //Register all proxys

        proxy.registerBlocks();

        proxy.registerItems();

        proxy.registerOreDict();

        proxy.registerEvents();

        proxy.registerRenderers();

        proxy.registerSounds();

        proxy.registerConfiguration();

        LogHelper.info("Pre Initialization (Ended after " + timer.elapsed(TimeUnit.MILLISECONDS) + "ms)");
    }

    @EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {

        final Stopwatch timer = Stopwatch.createStarted();
        LogHelper.info("Initialization (Started)");

        //TODO: Initialization

        proxy.registerRecipes();

        LogHelper.info("Initialization (Ended after " + timer.elapsed(TimeUnit.MILLISECONDS) + "ms)");

    }

    @EventHandler
    public void onFMLPostInitialization(FMLPostInitializationEvent event) {

        final Stopwatch timer = Stopwatch.createStarted();
        LogHelper.info("Post Initialization (Started)");

        //TODO: Post Initialization

        LogHelper.info("Post Initialization (Ended after " + timer.elapsed(TimeUnit.MILLISECONDS) + "ms)");

    }
}
