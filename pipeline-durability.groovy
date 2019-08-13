import hudson.model.*;
import jenkins.model.*;

import org.jenkinsci.plugins.workflow.flow.GlobalDefaultFlowDurabilityLevel
import org.jenkinsci.plugins.workflow.flow.FlowDurabilityHint

def durabilityInstance = Jenkins.getInstance()
GlobalDefaultFlowDurabilityLevel.DescriptorImpl level = durabilityInstance.getExtensionList(GlobalDefaultFlowDurabilityLevel.DescriptorImpl.class).get(0);
level.setDurabilityHint(FlowDurabilityHint.PERFORMANCE_OPTIMIZED);
durabilityInstance.save()
