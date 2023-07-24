/*
 * Decompiled with CFR 0.148.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.IOUtils
 */
package com.nottoomanyitems.stepup;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;

public class VersionChecker
implements Runnable {
    private static boolean isLatestVersion = false;
    private static String latestVersion = "0.0.0";

    @Override
    public void run() {
        InputStream in = null;
        try {
            in = new URL("https://pastebin.com/raw/TdEijisE").openStream();
        }
        catch (MalformedURLException e) {
            isLatestVersion = true;
            IOUtils.closeQuietly((InputStream)in);
            return;
        }
        catch (IOException e) {
            isLatestVersion = true;
            IOUtils.closeQuietly((InputStream)in);
            return;
        }
        try {
            latestVersion = (String)IOUtils.readLines((InputStream)in).get(0);
        }
        catch (IOException e) {
            isLatestVersion = true;
            IOUtils.closeQuietly((InputStream)in);
            return;
        }
        finally {
            IOUtils.closeQuietly((InputStream)in);
        }
        System.out.println("Latest mod version = " + latestVersion);
        isLatestVersion = "1.0.1".equals(latestVersion);
        System.out.println("Are you running latest version = " + isLatestVersion);
    }

    public boolean isLatestVersion() {
        return isLatestVersion;
    }

    public static String getLatestVersion() {
        return latestVersion;
    }
}

