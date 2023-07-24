/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.client.registry.ClientRegistry
 *  cpw.mods.fml.common.eventhandler.SubscribeEvent
 *  cpw.mods.fml.common.gameevent.InputEvent
 *  cpw.mods.fml.common.gameevent.InputEvent$KeyInputEvent
 *  cpw.mods.fml.common.gameevent.TickEvent
 *  cpw.mods.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.event.ClickEvent
 *  net.minecraft.event.ClickEvent$Action
 *  net.minecraft.util.ChatComponentText
 *  net.minecraft.util.ChatStyle
 *  net.minecraft.util.EnumChatFormatting
 *  net.minecraft.util.IChatComponent
 */
package com.nottoomanyitems.stepup;

import com.nottoomanyitems.stepup.ConfigHandler;
import com.nottoomanyitems.stepup.Main;
import com.nottoomanyitems.stepup.VersionChecker;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;

public final class StepChanger {
    public static EntityPlayer player;
    public static KeyBinding myKey;
    public static boolean activated;
    public static Boolean firstRun;
    private String mc_version;

    public static void createKey() {
        myKey = new KeyBinding("开关自动跳跃", 36, "自动跳跃：彼梦版");
        ClientRegistry.registerKeyBinding((KeyBinding)myKey);
    }

    @SubscribeEvent
    public void tickEvent(TickEvent.PlayerTickEvent event) {
        player = event.player;
        String m = "";
        if (player.isSneaking()) {
            StepChanger.player.stepHeight = 0.6f;
        } else if (activated) {
            StepChanger.player.stepHeight = 1.25f;
            m = (Object)EnumChatFormatting.WHITE + " 自动跳跃 " + (Object)EnumChatFormatting.GREEN + "已启用";
        } else if (!activated) {
            StepChanger.player.stepHeight = 0.6f;
            m = (Object)EnumChatFormatting.WHITE + " 自动跳跃 " + (Object)EnumChatFormatting.RED + "已关闭";
        }
        if (firstRun.booleanValue()) {
            if (!Main.versionChecker.isLatestVersion()) {
                String m2 = "";
                ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://nottoomanyitems.wixsite.com/mods/step-up");
                m2 = (Object)EnumChatFormatting.GOLD + "Update Available: " + (Object)EnumChatFormatting.DARK_AQUA + "[" + (Object)EnumChatFormatting.YELLOW + "StepUp" + (Object)EnumChatFormatting.WHITE + " v" + VersionChecker.getLatestVersion() + (Object)EnumChatFormatting.DARK_AQUA + "]";
                ChatComponentText component = new ChatComponentText(m2);
                ChatStyle s = component.getChatStyle();
                s.setChatClickEvent(versionCheckChatClickEvent);
                component.setChatStyle(s);
                player.addChatMessage((IChatComponent)component);
            }
            player.addChatMessage((IChatComponent)new ChatComponentText(m));
            firstRun = false;
        }
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (myKey.isPressed()) {
            String m = "";
            if (activated) {
                activated = false;
                StepChanger.player.stepHeight = 0.6f;
                m = (Object)EnumChatFormatting.WHITE + " 自动跳跃 " + (Object)EnumChatFormatting.RED + "已关闭";;

            } else if (!activated) {
                activated = true;
                StepChanger.player.stepHeight = 1.25f;
                m = (Object)EnumChatFormatting.WHITE + " 自动跳跃 " + (Object)EnumChatFormatting.GREEN + "已启用";
            }
            ConfigHandler.changeConfig();
            player.addChatMessage((IChatComponent)new ChatComponentText(m));
        }
    }

    static {
        firstRun = true;
        activated = true;
        firstRun = true;
    }
}

