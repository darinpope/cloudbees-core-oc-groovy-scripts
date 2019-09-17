import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

def pluginManager = Jenkins.instance.getPluginManager();
def pluginWrapperToUninstall = pluginManager.getPlugin(${PLUGIN_TO_REMOVE});
if(pluginWrapperToUninstall != null) {
  pluginWrapperToUninstall.doDoUninstall();
  Jenkins.instance.doQuietDown(true,0);
  Jenkins.instance.doSafeRestart(null); 
}
