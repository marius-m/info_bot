package lt.markmerkk;

import lt.markmerkk.components.DaggerWebRunnerComponent;
import lt.markmerkk.interfaces.page.WPage;
import lt.markmerkk.interfaces.page.WPageFilterable;
import lt.markmerkk.interfaces.page.WPageResultSearchable;
import lt.markmerkk.modules.WebRunnerModule;
import lt.markmerkk.web_form_components.interfaces.WebFormComponent;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleWebRunnerDependencyTest {

    // Long test, should be avoided
    @Test
    @Ignore
    public void testDependencyInit() throws Exception {
        WebRunnerModule webRunnerModule = new WebRunnerModule(new WPage() {
            @Override
            public String url() {
                return null;
            }
        }, new WPageFilterable() {
            @Override
            public List<WebFormComponent> filterComponents() {
                return null;
            }
        }, new WPageResultSearchable() {
            @Override
            public String tableXpath() {
                return null;
            }

            @Override
            public String itemXpath() {
                return null;
            }
        });
        SimpleWebRunner webRunner = DaggerWebRunnerComponent
                .builder()
                .webRunnerModule(webRunnerModule)
                .build().runner();
        assertNotNull(webRunner);
        assertNotNull(webRunner.driver);
        assertNotNull(webRunner.filter);
        assertNotNull(webRunner.inspector);
        assertNotNull(webRunner.page);
    }
}