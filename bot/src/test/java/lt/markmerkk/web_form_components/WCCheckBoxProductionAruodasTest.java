package lt.markmerkk.web_form_components;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
@Ignore
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