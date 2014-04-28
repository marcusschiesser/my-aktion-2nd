package de.dpunkt.myaktion.test;

import de.dpunkt.myaktion.test.pages.LoginPage;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import java.io.File;

public abstract class AbstractITCase {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap.create(ZipImporter.class, "test.war").importFrom(new File("target/my-aktion.war"))
                .as(WebArchive.class);
        archive.delete("/WEB-INF/classes/META-INF/persistence.xml");
        archive.delete("/WEB-INF/myaktion-ds.xml");
        archive.addAsResource("META-INF/test-persistence.xml",
                "META-INF/persistence.xml");
        archive.addAsWebInfResource("test-ds.xml", "test-ds.xml");
        return archive;
    }

    protected void login() {
        final LoginPage loginPage = Graphene.goTo(LoginPage.class);
        loginPage.doLogin("max@mustermann.de", "secret");
    }

}
