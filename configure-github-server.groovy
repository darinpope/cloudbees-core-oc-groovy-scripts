import hudson.model.*
import jenkins.model.*
import org.jenkinsci.plugins.github.config.*

def instance = Jenkins.getInstance()
GitHubPluginConfig gitHubPluginConfig = GlobalConfiguration.all().get(GitHubPluginConfig.class)

GitHubServerConfig conf = new GitHubServerConfig("my-gh-api-token")
conf.setManageHooks(true)
conf.setName("My Cool GitHub Name")

gitHubPluginConfig.setConfigs(Arrays.<GitHubServerConfig>asList(conf))

instance.save()
