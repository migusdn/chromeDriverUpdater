package com.migusdn;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.ProtocolException;

public interface Updater {
    public String getCurrentVersion() throws ParserConfigurationException, IOException, SAXException;
    public String update() throws IOException, SAXException, ParserConfigurationException;
    public String findUsableVersion() throws IOException;

}
