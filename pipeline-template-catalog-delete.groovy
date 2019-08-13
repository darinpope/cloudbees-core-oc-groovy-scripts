import jenkins.model.*;
import org.jenkinsci.plugins.workflow.libs.*;
import jenkins.scm.api.SCMSource;
import jenkins.plugins.git.*;
import com.cloudbees.pipeline.governance.templates.*;
import com.cloudbees.pipeline.governance.templates.catalog.*;

List<CatalogWrapper> catalogWrappers = GlobalTemplateCatalogManagement.get().getCatalogs();
ArrayList<CatalogWrapper> al2 = (ArrayList<CatalogWrapper>)catalogWrappers.clone();
for(CatalogWrapper catalogWrapper : al2) {
   boolean result = GlobalTemplateCatalogManagement.get().removeCatalog(catalogWrapper.getCatalog())
}