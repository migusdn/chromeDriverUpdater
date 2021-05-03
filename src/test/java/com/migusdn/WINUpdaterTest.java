package com.migusdn;

import junit.framework.TestCase;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WINUpdaterTest extends TestCase {

    private Updater updater;
    public void setUp() throws Exception {
        super.setUp();
        updater = new WINUpdater();

    }

    public void testGetCurrentVersion() throws IOException, SAXException, ParserConfigurationException {
        String version = updater.getCurrentChromeVersion();
        System.out.println(version);
        assertNotNull(version);

    }
    public void testUpdate() throws ParserConfigurationException, SAXException, IOException {
        updater.update();
    }



    public void testFindUsableVersion() {
    }

    public void testGetCurrentDriverVersion() {
        System.out.println(updater.getCurrentDriverVersion());
    }
}