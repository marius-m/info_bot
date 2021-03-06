package lt.markmerkk.web_form_components;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCBaseInputFillTest {
    private WCBaseInput baseInput;

    @Before
    public void setUp() throws Exception {
        baseInput = spy(new WCBaseInput("asdf", "//path", "asdf") {
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() throws Exception {
        baseInput.fill(null);
    }

    @Test
    public void testValid() throws Exception {
        baseInput.fill(mock(WebElement.class));
    }
}