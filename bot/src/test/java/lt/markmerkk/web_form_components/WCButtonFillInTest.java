package lt.markmerkk.web_form_components;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCButtonFillInTest {

    @Test
    public void testNullElement() throws Exception {
        WCButton textComponent = new WCButton("asdf", "//somePath");
        textComponent.fill(null); // Should not do anything!
    }

    @Test
    public void testValid() throws Exception {
        WCButton textComponent = new WCButton("asdf", "//somePath");
        WebElement webElement = mock(WebElement.class);
        textComponent.fill(webElement);
        verify(webElement, times(1)).click();
    }

}