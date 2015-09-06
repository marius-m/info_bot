package lt.markmerkk;

import lt.markmerkk.components.DaggerWebRunnerComponent;
import lt.markmerkk.interfaces.page.WPage;
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
        SimpleWebRunner webRunner = DaggerWebRunnerComponent
                .builder()
                .webRunnerModule(new WebRunnerModule(new WPage() {
                    @Override
                    public String url() {
                        return null;
                    }

                    @Override
                    public List<WebFormComponent> filterComponents() {
                        return null;
                    }
                }))
                .build().runner();
        assertNotNull(webRunner);
        assertNotNull(webRunner.driver);
        assertNotNull(webRunner.filter);
        assertNotNull(webRunner.page);
    }
}