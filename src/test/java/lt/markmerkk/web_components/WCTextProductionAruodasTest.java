package lt.markmerkk.web_components;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 * Production test with running web driver if the functionality is correct.
 *
 * This is a large test. This should not run as daily one!
 */
@Ignore
public class WCTextProductionAruodasTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("http://www.aruodas.lt/");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testFillInInput() throws Exception {
        WCText textInput = new WCText("test", "//input[@name='FAreaOverAllMin']", "100");

        WebElement element = textInput.find(driver);
        assertNotNull(element);
        assertEquals("", element.getText());
        textInput.fill(element);
        assertEquals("100", element.getText());
    }
}