/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  cpw.mods.fml.common.network.FMLNetworkEvent
 *  cpw.mods.fml.common.network.FMLNetworkEvent$ClientConnectedToServerEvent
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ServerData
 */
package com.nottoomanyitems.stepup;

import com.nottoomanyitems.stepup.ConfigHandler;
import com.nottoomanyitems.stepup.StepChanger;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;

public class NetHandler {
    public static String serverIP;

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public void clientConnectedToServer(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        ServerData serverData = Minecraft.getMinecraft().func_147104_D();
        serverIP = serverData != null ? serverData.serverIP.replace(".", "") : "0000";
        StepChanger.firstRun = true;
        ConfigHandler.loadConfig();
    }
}

