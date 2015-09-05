package lt.markmerkk.web_components;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCCheckBoxProductionAruodasTest extends BaseProductionTest {
    @Test
    public void testFillInInput() throws Exception {
        WCCheckBox textInput = new WCCheckBox("test", "//select[@name='FRoomNumMin']/option[@value='3']");

        WebElement element = textInput.find(driver);
        assertNotNull(element);
        assertFalse(element.isSelected());
        textInput.fill(element);
        assertTrue(element.isSelected());
    }

}