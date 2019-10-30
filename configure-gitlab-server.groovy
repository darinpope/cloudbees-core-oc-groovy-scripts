import hudson.model.*
import jenkins.model.*
import io.jenkins.plugins.gitlabserverconfig.servers.*

def instance = Jenkins.getInstance()
def config = instance.getDescriptor("io.jenkins.plugins.gitlabserverconfig.servers.GitLabServers")

GitLabServer endpoint = new GitLabServer(
  name="myDisplayName",
  serverUrl="https://foo.com/",
  credentialsId="bb-creds"
)
server.setManageWebHooks(true)
server.setManageSystemHooks(true)

config.setServers(Arrays.<GitLabServer>asList(endpoint))
instance.save()
