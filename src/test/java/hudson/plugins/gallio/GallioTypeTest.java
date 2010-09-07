package hudson.plugins.gallio;

import com.thalesgroup.dtkit.metrics.model.InputMetric;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.mockito.Mockito.anyString;

public class GallioTypeTest {

    private void backwardCompatibility(String pattern, boolean faildedIfNotNew, boolean deleteJUnitFiles) throws Exception {

        GallioType gallioType = new GallioType(pattern, faildedIfNotNew, deleteJUnitFiles);

        //Test new descriptor
        Assert.assertNull(gallioType.getDescriptor());

        //Test new Object type
        Method readResolveMethod = GallioType.class.getMethod("readResolve");
        Object object = readResolveMethod.invoke(gallioType);
        Assert.assertTrue(object.getClass() == GallioPluginType.class);

        GallioPluginType gallioPluginType = (GallioPluginType) object;
        Assert.assertNotNull(gallioPluginType.getDescriptor());

        Assert.assertEquals(gallioType.getPattern(), gallioPluginType.getPattern());
        Assert.assertEquals(gallioType.isDeleteJUnitFiles(), gallioPluginType.isDeleteOutputFiles());
        Assert.assertEquals(gallioType.isFaildedIfNotNew(), gallioPluginType.isFaildedIfNotNew());

        InputMetric inputMetric = gallioPluginType.getInputMetric();
        Assert.assertNotNull(inputMetric);
    }

    @Test
    public void test1() throws Exception {
        backwardCompatibility(anyString(), true, true);
    }

    @Test
    public void test2() throws Exception {
        backwardCompatibility(anyString(), true, false);
    }

    @Test
    public void test3() throws Exception {
        backwardCompatibility(anyString(), false, true);
    }

    @Test
    public void test4() throws Exception {
        backwardCompatibility(anyString(), false, false);
    }
}
