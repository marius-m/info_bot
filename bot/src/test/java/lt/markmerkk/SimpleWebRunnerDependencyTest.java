package lt.markmerkk;

import lt.markmerkk.components.DaggerSimpleWebRunnerComponent;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleWebRunnerDependencyTest {

    // Long test, should be avoided
    @Test
    @Ignore
    public void testDependencyInit() throws Exception {
        SimpleWebRunner webRunner = DaggerSimpleWebRunnerComponent.create().runner();
        webRunner.run();
        assertNotNull(webRunner);
        assertNotNull(webRunner.driver);
        assertNotNull(webRunner.filter);
        assertNotNull(webRunner.page);
    }
}