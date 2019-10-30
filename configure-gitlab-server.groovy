import hudson.model.*
import jenkins.model.*
import io.jenkins.plugins.gitlabserverconfig.servers.*
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.User;
import io.jenkins.plugins.gitlabserverconfig.credentials.PersonalAccessToken;

def instance = Jenkins.getInstance()
def config = instance.getDescriptor("io.jenkins.plugins.gitlabserverconfig.servers.GitLabServers")

GitLabServer server = new GitLabServer(
  serverUrl="https://gitlab.mycompany.com/",
  name="GitLab",
  credentialsId="my-gitlab-access-token"
)
server.setManageWebHooks(true)
server.setManageSystemHooks(true)

config.setServers(Arrays.<GitLabServer>asList(server))

PersonalAccessToken credentials = server.getCredentials();
if (credentials != null) {
  String privateToken = credentials.getToken().getPlainText();
  GitLabApi gitLabApi = new GitLabApi(server.serverUrl, privateToken);
  User user = gitLabApi.getUserApi().getCurrentUser();
  if (user != null && user.getUsername() != null) {
    println("User found")
  } else {
    println("User not found") 
  }
} else {
  println("Credentials not found")
}

instance.save()
