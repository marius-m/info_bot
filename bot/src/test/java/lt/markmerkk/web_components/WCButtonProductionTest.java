package lt.markmerkk.web_components;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
@Ignore
public class WCButtonProductionTest extends BaseProductionTest {
    @Test
    public void testName() throws Exception {
        WCButton textInput = new WCButton("test", "//form[@id='searchForm']//input[@type='submit']");

        WebElement element = textInput.find(driver);
        assertNotNull(element);
        textInput.fill(element);
    }
}