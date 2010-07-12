package hudson.plugins.gallio;

import org.junit.Test;

public class GallioXSLTest extends AbstractXUnitXSLTest {


    @Test
    public void testTransformation() throws Exception {
        convertAndValidate(GallioInputMetric.class, "Gallio-simple.xml", "JUnit-simple.xml");
    }

    @Test
    public void testTransformationMultiNamespace() throws Exception {
        convertAndValidate(GallioInputMetric.class, "Gallio-multinamespace.xml", "JUnit-multinamespace.xml");
    }

    @Test
    public void testTransformedIssue1077() throws Exception {
        convertAndValidate(GallioInputMetric.class, "Gallio-issue1077.xml", "JUnit-issue1077.xml");
    }

    @Test
    public void testTransformedIgnored() throws Exception {
        convertAndValidate(GallioInputMetric.class, "Gallio-ignored.xml", "JUnit-ignored.xml");
    }

    @Test
    public void testTransformationFailure() throws Exception {
        convertAndValidate(GallioInputMetric.class, "Gallio-failure.xml", "JUnit-failure.xml");
    }

}
