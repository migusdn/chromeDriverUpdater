package com.migusdn;

public class DriverUpdater {
    private String OS;
    private Updater updater;
    DriverUpdater(String OS){
        this.OS = OS;
        if (OS.indexOf("win") >= 0) {
            this.updater = new WINUpdater();
        } else if (OS.indexOf("mac") >= 0) {
            this.updater = new OSXUpdater();
        } else if (OS.indexOf("nix") >= 0
                || OS.indexOf("nux") >= 0
                || OS.indexOf("aix") > 0) {
            this.updater = new UNIXUpdater();
        } else{
            System.out.println("Your OS is not support!!");
        }
    }

}
