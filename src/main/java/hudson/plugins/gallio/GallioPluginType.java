package hudson.plugins.gallio;

import hudson.Extension;
import org.jenkinsci.lib.dtkit.descriptor.TestTypeDescriptor;
import org.jenkinsci.lib.dtkit.type.TestType;
import org.kohsuke.stapler.DataBoundConstructor;

public class GallioPluginType extends TestType {

    @DataBoundConstructor
    public GallioPluginType(String pattern, boolean faildedIfNotNew, boolean deleteOutputFiles, boolean stopProcessingIfError) {
        super(pattern, faildedIfNotNew, deleteOutputFiles, stopProcessingIfError);
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

