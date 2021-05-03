package com.migusdn;

import junit.framework.TestCase;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DriverUpdaterTest extends TestCase {
    DriverUpdater driverUpdater;
    public void setUp() throws Exception {
        super.setUp();
        driverUpdater = new DriverUpdater();
    }
    public void testGetCurrentChromeVersion() throws ParserConfigurationException, SAXException, IOException {
        System.out.println(driverUpdater.getCurrentChromeVersion());
    }

    public void testUpdateDriver() throws IOException, SAXException, ParserConfigurationException {
        driverUpdater.updateDriver();
    }
}