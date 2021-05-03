package com.migusdn;

import com.migusdn.Util.Unzip;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WINUpdater implements Updater {
    private static String PATH = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.VisualElementsManifest.xml";
    private String version = null;
    private String chromeDriverStorageUrl = "https://chromedriver.storage.googleapis.com/";
    private Unzip unzip = new Unzip();
    @Override
    public String getCurrentVersion() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(new File(PATH));
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("VisualElements");
        this.version = document
                .getElementsByTagName("VisualElements")
                .item(0)
                .getAttributes()
                .getNamedItem("Square150x150Logo")
                .getNodeValue().split("\\\\")[0];
        return this.version;
    }

    @Override
    public String update() throws IOException, SAXException, ParserConfigurationException {
        if(version==null)
            getCurrentVersion();
        String UsableVersion = findUsableVersion();
        try(InputStream in = new URL(chromeDriverStorageUrl+UsableVersion+"/chromedriver_win32.zip").openStream()){
            Path DriverPath = Paths.get("chromedriver_win32.zip");
            Files.copy(in, DriverPath);
            unzip.unzip("chromedriver_win32.zip","./");
        }
        File temp = new File("chromedriver_win32.zip");
        temp.delete();
        return findUsableVersion();

    }

    @Override
    public String findUsableVersion() throws IOException {
        System.out.println();
        URL url = new URL(chromeDriverStorageUrl+"LATEST_RELEASE_"+version.split("\\.")[0]);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET"); // add request header
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine; StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close(); // print result
        System.out.println("HTTP 응답 코드 : " + responseCode);
        System.out.println("HTTP body : " + response.toString());
        return response.toString();
    }
}
