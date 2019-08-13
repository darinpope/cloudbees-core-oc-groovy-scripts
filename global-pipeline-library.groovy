import jenkins.model.*;
import org.jenkinsci.plugins.workflow.libs.*;
import jenkins.scm.api.SCMSource;

SCMSource scm = new jenkins.plugins.git.GitSCMSource("<git repository url; ssh or https")
scm.setCredentialsId("<real credential id for the above git url>")

LibraryRetriever libRetriever = new SCMSourceRetriever(scm)

LibraryConfiguration libConfig = new LibraryConfiguration("common-pipelines", libRetriever)
libConfig.setDefaultVersion("master")
libConfig.setImplicit(false)
libConfig.setIncludeInChangesets(true)

List<LibraryConfiguration> libraries= new ArrayList<LibraryConfiguration>()
libraries.add(libConfig)

GlobalLibraries globalLibs = GlobalConfiguration.all().get(GlobalLibraries.class)
globalLibs.setLibraries(libraries)
