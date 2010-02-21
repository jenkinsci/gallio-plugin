package hudson.plugins.gallio;

import com.thalesgroup.hudson.plugins.xunit.types.XUnitType;
import com.thalesgroup.hudson.plugins.xunit.types.XUnitTypeDescriptor;
import hudson.Extension;
import org.kohsuke.stapler.DataBoundConstructor;


public class GallioType extends XUnitType {


    @DataBoundConstructor
    public GallioType(String pattern, boolean faildedIfNotNew, boolean deleteJUnitFiles) {
        super(pattern, faildedIfNotNew, deleteJUnitFiles);
    }

    public String getXsl() {
        return "gallio-to-junit.xsl";
    }

    public XUnitTypeDescriptor<?> getDescriptor() {
        return new GallioType.DescriptorImpl();
    }

    @Extension
    public static class DescriptorImpl extends XUnitTypeDescriptor<GallioType> {

        public DescriptorImpl() {
            super(GallioType.class);
        }

        @Override
        public String getDisplayName() {
            return Messages.gallio_label();
        }

        public String getId() {
            return "gallio";
        }

    }
}
