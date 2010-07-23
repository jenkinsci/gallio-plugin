package hudson.plugins.gallio;

import com.thalesgroup.dtkit.metrics.api.InputMetric;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyString;

public class GallioTypeTest {

    @Test
    public void backwardCompatibility() throws Exception {

        Constructor c = GallioType.class.getConstructor(String.class, boolean.class, boolean.class);
        GallioType gallioType = (GallioType) c.newInstance(anyString(), anyBoolean(), anyBoolean());

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
}
