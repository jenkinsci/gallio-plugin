package hudson.plugins.gallio;

import com.thalesgroup.dtkit.metrics.hudson.api.descriptor.TestTypeDescriptor;
import com.thalesgroup.hudson.plugins.xunit.types.XUnitType;


@SuppressWarnings("unused")
public class GallioType extends XUnitType {

    public GallioType(String pattern, boolean faildedIfNotNew, boolean deleteJUnitFiles) {
        super(pattern, faildedIfNotNew, deleteJUnitFiles);
    }

    public TestTypeDescriptor getDescriptor() {
        return null;
    }

    /**
     * Call at Hudson startup for backward compatibility
     *
     * @return an new hudson object
     */
    public Object readResolve() {
        return new GallioPluginType(this.getPattern(), this.isFaildedIfNotNew(), this.isDeleteJUnitFiles());
    }
}

