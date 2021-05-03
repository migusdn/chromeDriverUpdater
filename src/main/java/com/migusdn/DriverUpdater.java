package com.migusdn;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DriverUpdater {
    private String OS;
    private Updater updater;
    DriverUpdater(){
        this.OS = System.getProperty("os.name");
        if (OS.contains("Win")) {
            this.updater = new WINUpdater();
        } else if (OS.contains("mac")) {
            this.updater = new OSXUpdater();
        } else if (OS.contains("nix")
                || OS.contains("nux")
                || OS.contains("aix")) {
            this.updater = new UNIXUpdater();
        } else{
            System.out.println("Your OS is not support!!");
        }
    }
    public String getCurrentChromeVersion() throws IOException, SAXException, ParserConfigurationException {
        return updater.getCurrentChromeVersion();
    }
    public void updateDriver() throws ParserConfigurationException, SAXException, IOException {
        updater.update();
    }
}
