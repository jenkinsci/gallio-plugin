package hudson.plugins.gallio;

import com.thalesgroup.dtkit.junit.model.JUnitModel;
import com.thalesgroup.dtkit.metrics.model.InputMetricXSL;
import com.thalesgroup.dtkit.metrics.model.InputType;
import com.thalesgroup.dtkit.metrics.model.OutputMetric;


public class GallioInputMetric extends InputMetricXSL {

    @Override
    public InputType getToolType() {
        return InputType.TEST;
    }

    @Override
    public String getToolName() {
        return Messages.gallio_toolName();
    }

    @Override
    public String getToolVersion() {
        return "N/A";
    }

    @Override
    public String getXslName() {
        return "gallio-1.0-to-junit-1.0.xsl";
    }

    @Override
    public String getInputXsd() {
        return null;
    }

    @Override
    public OutputMetric getOutputFormatType() {
        return JUnitModel.OUTPUT_JUNIT_1_0;
    }
}

