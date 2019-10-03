import com.cloudbees.jenkins.plugins.awscredentials.AWSCredentialsImpl

def changeKeyAndSecret = { id, newAccessKey, newSecretKey ->
    def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
        com.cloudbees.jenkins.plugins.awscredentials.AmazonWebServicesCredentials.class,
        jenkins.model.Jenkins.instance
    )

    def c = creds.findResult { it.id == id ? it : null }

    if ( c ) {
        println "found credential ${c.id} for id ${c.id}"

        def credentials_store = jenkins.model.Jenkins.instance.getExtensionList(
            'com.cloudbees.plugins.credentials.SystemCredentialsProvider'
            )[0].getStore()

        def result = credentials_store.updateCredentials(
            com.cloudbees.plugins.credentials.domains.Domain.global(), 
            c, 
            new AWSCredentialsImpl(
              c.scope, 
              c.id, 
              newAccessKey,
              newSecretKey,
              c.description, 
              c.iamRoleArn, 
              c.iamMfaSerialNumber)
            )

        if (result) {
            println "key and secret changed for ${id}" 
        } else {
            println "failed to change key and secret for ${id}"
        }
    } else {
      println "could not find credential for ${username}"
    }
}

changeKeyAndSecret(args[0], args[1], args[2])

// oc-cli groovy = aws-credential-id aeg221 efwef93 < rotate-aws-key-secret.groovy
// oc-cli ===> java -jar <path to downloaded>/jenkins-cli.jar -http -noKeyAuth -auth <user>:<token> -s http://oc:8888/ $*
