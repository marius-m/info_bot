package lt.markmerkk.web_components;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCTextFillInTest {

    @Test
    public void testNullElement() throws Exception {
        WCText textComponent = new WCText("//somePath", "value_to_fill");
        textComponent.fillIn(null); // Should not do anything!
    }

    @Test
    public void testValid() throws Exception {
        WCText textComponent = new WCText("//somePath", "value_to_fill");
        WebElement webElement = mock(WebElement.class);
        textComponent.fillIn(webElement);
        verify(webElement, times(1)).clear();
        verify(webElement, times(1)).sendKeys("value_to_fill");
    }
}