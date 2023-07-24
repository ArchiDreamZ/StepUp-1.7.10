/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.Mod
 *  cpw.mods.fml.common.Mod$EventHandler
 *  cpw.mods.fml.common.Mod$Instance
 *  cpw.mods.fml.common.SidedProxy
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 */
package com.nottoomanyitems.stepup;

import com.nottoomanyitems.stepup.CommonProxy;
import com.nottoomanyitems.stepup.VersionChecker;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="stepup", name="StepUp", version="1.0.2-mc1.7.10", acceptedMinecraftVersions="[1.7.10]")
public class Main {
    @SidedProxy(clientSide="com.nottoomanyitems.stepup.ClientProxy", serverSide="com.nottoomanyitems.stepup.ServerProxy")
    public static CommonProxy proxy;
    public static final String MODID = "stepup";
    public static final String MODNAME = "StepUp";
    public static final String VERSION = "1.0.2-mc1.7.10";
    public static final String MODVERSION = "1.0.2";
    @Mod.Instance
    public static Main instance;
    public static VersionChecker versionChecker;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    static {
        instance = new Main();
    }
}

