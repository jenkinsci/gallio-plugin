package hudson.plugins.gallio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * Interface for mocking out the GallioReportTransformer from testing.
 */
public interface TestReportTransformer {
    /**
     * Transforms the gallio file stream to junit files in the specified output path
     * 
     * @param gallioFileStream gallio report file stream
     * @param junitOutputPath the output path to store junit reports to
     * @throws ParserConfigurationException 
     */
    void transform(InputStream gallioFileStream, File junitOutputPath) throws IOException, TransformerException,
            SAXException, ParserConfigurationException;
}
