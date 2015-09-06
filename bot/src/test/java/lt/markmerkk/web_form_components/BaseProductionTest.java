package lt.markmerkk.web_form_components;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class BaseProductionTest {
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://www.aruodas.lt/");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
