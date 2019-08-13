import jenkins.model.*;
import org.jenkinsci.plugins.workflow.libs.*;
import jenkins.scm.api.SCMSource;
import jenkins.plugins.git.*;
import com.cloudbees.pipeline.governance.templates.*;
import com.cloudbees.pipeline.governance.templates.catalog.*;

SCMSource scm = new GitSCMSource("https://github.com/darinpope/pipeline-template-catalogs.git");
//scm.setCredentialsId("<real credential id>")

TemplateCatalog catalog = new TemplateCatalog(scm, "master");
catalog.setUpdateInterval("15m");

GlobalTemplateCatalogManagement.get().addCatalog(catalog);
GlobalTemplateCatalogManagement.get().save();

catalog.updateFromSCM();