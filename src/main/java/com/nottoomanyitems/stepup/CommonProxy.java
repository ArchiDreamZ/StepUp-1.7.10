/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 *  cpw.mods.fml.common.eventhandler.EventBus
 */
package com.nottoomanyitems.stepup;

import com.nottoomanyitems.stepup.ConfigHandler;
import com.nottoomanyitems.stepup.NetHandler;
import com.nottoomanyitems.stepup.StepChanger;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventBus;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        FMLCommonHandler.instance().bus().register((Object)new NetHandler());
        StepChanger.createKey();
        ConfigHandler.load(e);
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
        FMLCommonHandler.instance().bus().register((Object)new StepChanger());
    }
}

