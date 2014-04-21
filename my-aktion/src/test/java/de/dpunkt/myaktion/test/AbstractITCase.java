package de.dpunkt.myaktion.test;

import org.jboss.arquillian.container.test.api.Deployment;
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
}
