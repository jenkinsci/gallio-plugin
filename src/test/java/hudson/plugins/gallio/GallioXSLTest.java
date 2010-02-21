package hudson.plugins.gallio;

import org.junit.Test;

public class GallioXSLTest extends AbstractXUnitXSLTest {

    public GallioXSLTest() {
        super(GallioType.class);
    }

    @Test
    public void testTransformation() throws Exception {
        processTransformation("Gallio-simple.xml", "JUnit-simple.xml");
    }

    @Test
    public void testTransformationMultiNamespace() throws Exception {
        processTransformation("Gallio-multinamespace.xml", "JUnit-multinamespace.xml");
    }

    @Test
    public void testTransformedIssue1077() throws Exception {
        processTransformation("Gallio-issue1077.xml", "JUnit-issue1077.xml");
    }

    @Test
    public void testTransformedIgnored() throws Exception {
        processTransformation("Gallio-ignored.xml", "JUnit-ignored.xml");
    }

    @Test
    public void testTransformationFailure() throws Exception {
        processTransformation("Gallio-failure.xml", "JUnit-failure.xml");
    }

}
