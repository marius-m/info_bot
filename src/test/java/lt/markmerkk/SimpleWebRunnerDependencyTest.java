package lt.markmerkk;

import lt.markmerkk.components.DaggerSimpleWebRunnerComponent;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleWebRunnerDependencyTest {
    @Test
    public void testDependencyInit() throws Exception {
        SimpleWebRunner webRunner = DaggerSimpleWebRunnerComponent.create().maker();
        webRunner.run();
        assertNotNull(webRunner);
        assertNotNull(webRunner.driver);
        assertNotNull(webRunner.filter);
        assertNotNull(webRunner.page);
    }
}