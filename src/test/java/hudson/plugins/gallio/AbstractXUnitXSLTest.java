package hudson.plugins.gallio;

import com.thalesgroup.hudson.plugins.xunit.types.XUnitType;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Transform;
import org.custommonkey.xmlunit.XMLUnit;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.lang.reflect.Constructor;

import static org.junit.Assert.assertTrue;


public class AbstractXUnitXSLTest {

    private Class<? extends XUnitType> type;

    protected AbstractXUnitXSLTest(Class<? extends XUnitType> type) {
        this.type = type;
        setUp();
    }

    public void setUp() {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setNormalizeWhitespace(true);
        XMLUnit.setIgnoreComments(true);
    }


    protected void processTransformation(String source, String target)
            throws IllegalAccessException, InstantiationException, IOException, TransformerException, SAXException {

        try {
            Constructor typeContructor = type.getConstructors()[0];
            Transform myTransform = new Transform(new InputSource(
                    type.getResourceAsStream(source)), new InputSource(type.getResourceAsStream(((XUnitType) typeContructor.newInstance("default", true, true)).getXsl())));
            Diff myDiff = new Diff(XUnitXSLUtil.readXmlAsString(target), myTransform);
            assertTrue("XSL transformation did not work" + myDiff, myDiff.similar());

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            assertTrue(false);
        }
    }

}
