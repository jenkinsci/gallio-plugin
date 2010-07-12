package hudson.plugins.gallio;

import com.thalesgroup.dtkit.metrics.hudson.api.descriptor.TestTypeDescriptor;
import com.thalesgroup.dtkit.metrics.hudson.api.type.TestType;
import hudson.Extension;
import org.kohsuke.stapler.DataBoundConstructor;

public class GallioPluginType extends TestType {

    @DataBoundConstructor
    public GallioPluginType(String pattern, boolean faildedIfNotNew, boolean deleteOutputFiles) {
        super(pattern, faildedIfNotNew, deleteOutputFiles);
    }

    public TestTypeDescriptor<?> getDescriptor() {
        return new GallioPluginType.DescriptorImpl();
    }

    @Extension
    public static class DescriptorImpl extends TestTypeDescriptor<GallioPluginType> {

        public DescriptorImpl() {
            super(GallioPluginType.class, GallioInputMetric.class);
        }

        public String getId() {
            return GallioPluginType.class.getCanonicalName();
        }

    }

}

