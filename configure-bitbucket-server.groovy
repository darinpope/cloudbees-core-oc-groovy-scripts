import hudson.model.*
import jenkins.model.*
import com.cloudbees.jenkins.plugins.bitbucket.endpoints.*

def instance = Jenkins.getInstance()
def config = instance.getDescriptor("com.cloudbees.jenkins.plugins.bitbucket.endpoints.BitbucketEndpointConfiguration")

AbstractBitbucketEndpoint endpoint = new BitbucketServerEndpoint(
  displayName="myDisplayName",
  serverUrl="https://foo.com/",
  manageHooks=false,
  credentialsId="bb-creds"
)

config.setEndpoints(Arrays.<AbstractBitbucketEndpoint>asList(endpoint))
instance.save()