package com.migusdn;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.ProtocolException;

public interface Updater {
    String getCurrentChromeVersion() throws ParserConfigurationException, IOException, SAXException;
    void update() throws IOException, SAXException, ParserConfigurationException;
    String findUsableVersion() throws IOException;
    String getCurrentDriverVersion();
}
