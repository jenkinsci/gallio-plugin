package hudson.plugins.gallio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class XUnitXSLUtil {

    public static String readXmlAsString(String resourceName)
            throws IOException {
        String xmlString = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(XUnitXSLUtil.class.getResourceAsStream(resourceName)));
        String line = reader.readLine();
        while (line != null) {
            xmlString += line + "\n";
            line = reader.readLine();
        }
        reader.close();

        return xmlString;
    }
    
}
