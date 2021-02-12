import jenkins.model.Jenkins
import hudson.ExtensionList

import com.cloudbees.jenkins.plugins.notification.api.NotificationConfiguration
import com.cloudbees.jenkins.plugins.notification.spi.Router
import com.cloudbees.opscenter.plugins.notification.OperationsCenterRouter

//TODO: Don't use this script. 
//TODO: use CloudBees CI CasC instead 

// def instance = Jenkins.getInstance();

//Router r = new OperationsCenterRouter();

//NotificationConfiguration config = ExtensionList.lookupSingleton(NotificationConfiguration.class);
//config.setRouter(r);
//config.setEnabled(true);
//config.save();
//config.onLoaded();

//instance.save();
