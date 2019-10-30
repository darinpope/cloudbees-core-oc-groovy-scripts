import jenkins.model.Jenkins
import jenkins.model.JenkinsLocationConfiguration

def jenkinsLocationConfiguration = JenkinsLocationConfiguration.get()
jenkinsLocationConfiguration.setAdminAddress("Jenkins Admin <admin@jenkins.com>")
jenkinsLocationConfiguration.save()
