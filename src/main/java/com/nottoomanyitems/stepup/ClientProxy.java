/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.event.FMLInitializationEvent
 *  cpw.mods.fml.common.event.FMLPostInitializationEvent
 *  cpw.mods.fml.common.event.FMLPreInitializationEvent
 */
package com.nottoomanyitems.stepup;

import com.nottoomanyitems.stepup.CommonProxy;
import com.nottoomanyitems.stepup.Main;
import com.nottoomanyitems.stepup.VersionChecker;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy
extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
        Main.versionChecker = new VersionChecker();
        Thread versionCheckThread = new Thread((Runnable)Main.versionChecker, "Version Check");
        versionCheckThread.start();
    }
}

