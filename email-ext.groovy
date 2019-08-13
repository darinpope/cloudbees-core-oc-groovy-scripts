import hudson.model.*;
import jenkins.model.*;
import hudson.tools.*;
import hudson.util.Secret;

// This script assumes you have setup the SMTP server on the master already.
// It could have been done directly on the master or
// through the Miscellaneous Configuration Container job type on the OC

def emailExtInstance = Jenkins.getInstance()
def mailServer = emailExtInstance.getDescriptor("hudson.tasks.Mailer")

def extmailServer = emailExtInstance.getDescriptor("hudson.plugins.emailext.ExtendedEmailPublisher")
extmailServer.setSmtpServer(mailServer.getSmtpServer())
extmailServer.setSmtpPort(mailServer.getSmtpPort())
extmailServer.setSmtpUsername(mailServer.getSmtpAuthUserName())
extmailServer.setSmtpPassword(mailServer.getSmtpAuthPassword())
extmailServer.setDefaultSuffix(mailServer.getDefaultSuffix())

emailExtInstance.save()