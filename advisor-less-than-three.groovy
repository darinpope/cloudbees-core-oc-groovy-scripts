import com.cloudbees.jenkins.plugins.advisor.*

println "Configuration of Advisor ..."

def config = AdvisorGlobalConfiguration.instance

config.email = "test@email.com"
config.cc = "testCC@email.com" // optional
config.isValid = true
config.nagDisabled = true
config.acceptToS = true

config.save()
println "Configuration of Advisor done."
