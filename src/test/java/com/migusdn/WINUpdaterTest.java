package com.migusdn;

import junit.framework.TestCase;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class WINUpdaterTest extends TestCase {

    private Updater updater;
    public void setUp() throws Exception {
        super.setUp();
        updater = new WINUpdater();

    }

    public void testGetCurrentVersion() throws IOException, SAXException, ParserConfigurationException {
        String version = updater.getCurrentVersion();
        System.out.println(version);
        assertNotNull(version);
    }

    public void testUpdate() throws ParserConfigurationException, SAXException, IOException {
        assertNotNull(updater.update());
    }

    public void testFindUsableVersion() {
    }
}