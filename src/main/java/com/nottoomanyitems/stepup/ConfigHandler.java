/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.client.event.ConfigChangedEvent
 *  cpw.mods.fml.client.event.ConfigChangedEvent$OnConfigChangedEvent
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.eventhandler.EventBus
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.common.config.Configuration
 *  net.minecraftforge.common.config.Property
 */
package com.nottoomanyitems.stepup;

import com.nottoomanyitems.stepup.NetHandler;
import com.nottoomanyitems.stepup.StepChanger;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler {
    public static Configuration config;

    public static void load(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register((Object)new ConfigHandler());
    }

    public static void reloadConfig() {
        if (config.hasChanged()) {
            config.save();
        }
    }

    public static void loadConfig() {
        StepChanger.activated = config.get(NetHandler.serverIP, "activated", true).getBoolean();
        ConfigHandler.reloadConfig();
    }

    public static void changeConfig() {
        Property someProp = config.get(NetHandler.serverIP, "activated", StepChanger.activated);
        someProp.set(StepChanger.activated);
        ConfigHandler.reloadConfig();
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals("stepup")) {
            ConfigHandler.reloadConfig();
        }
    }
}

