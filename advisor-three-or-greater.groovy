import com.cloudbees.jenkins.plugins.advisor.*
import com.cloudbees.jenkins.plugins.advisor.client.model.*

println "Configuration of Advisor ..."

def config = AdvisorGlobalConfiguration.instance

config.acceptToS = true
config.email = "test@email.com"
config.ccs = [new Recipient("list1@acme.com"),new Recipient("list2@acme.com")] // optional
config.nagDisabled = true // optional

config.save()
println "Configuration of Advisor done."
