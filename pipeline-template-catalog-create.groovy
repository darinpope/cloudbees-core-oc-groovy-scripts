import jenkins.model.*;
import org.jenkinsci.plugins.workflow.libs.*;
import jenkins.scm.api.SCMSource;
import jenkins.plugins.git.*;
import com.cloudbees.pipeline.governance.templates.*;
import com.cloudbees.pipeline.governance.templates.catalog.*;

//NOTE: the repo below requires that the Kubernetes plugin is installed
//      because one of the templates uses a Kubernetes agent

SCMSource scm = new GitSCMSource("https://github.com/darinpope/pipeline-template-catalogs.git");
//scm.setCredentialsId("<real credential id>")

TemplateCatalog catalog = new TemplateCatalog(scm, "master");
catalog.setUpdateInterval("15m");

GlobalTemplateCatalogManagement.get().addCatalog(catalog);
GlobalTemplateCatalogManagement.get().save();

catalog.updateFromSCM();