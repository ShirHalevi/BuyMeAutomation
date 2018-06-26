import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BrowserAndURL {
    public static String getData(String browserType) throws Exception {
        //reutrn the browser type from the xml file
        File fXmlFile = new File("C:\\Users\\shir halevi\\Desktop\\qaexpert\\buyMe\\BrowserAndUrl.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(browserType).item(0).getTextContent();

    }
}
