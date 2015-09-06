package lt.markmerkk;

import lt.markmerkk.components.DaggerWebRunnerComponent;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.modules.WebRunnerModule;
import lt.markmerkk.web_components.interfaces.WebInputComponent;
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
                    public List<WebInputComponent> filterComponents() {
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