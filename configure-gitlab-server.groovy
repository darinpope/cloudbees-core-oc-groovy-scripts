import hudson.model.*
import jenkins.model.*
import io.jenkins.plugins.gitlabserverconfig.servers.*

def instance = Jenkins.getInstance()
def config = instance.getDescriptor("io.jenkins.plugins.gitlabserverconfig.servers.GitLabServers")

GitLabServer endpoint = new GitLabServer(
  serverUrl="https://foo.com/",
  name="myDisplayName",
  credentialsId="bb-creds"
)
endpoint.setManageWebHooks(true)
endpoint.setManageSystemHooks(true)

config.setServers(Arrays.<GitLabServer>asList(endpoint))
instance.save()
