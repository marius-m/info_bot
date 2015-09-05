package lt.markmerkk.web_components;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCBaseInputFindTest {

    private WCBaseInput baseInput;

    @Before
    public void setUp() throws Exception {
        baseInput = spy(new WCBaseInput("asdf", "//path", "asdf") {
            @Override
            WebElement findElement(WebDriver driver) throws NoSuchElementException, IllegalArgumentException {
                return null;
            }

            @Override
            void fillElement(WebElement element) throws WebDriverException, IllegalArgumentException {

            }
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFillNullInput() throws Exception {
        baseInput.find(null);
    }

    @Test(expected = WebDriverException.class)
    public void testWebDriverError() throws Exception {
        when(baseInput.findElement(any(WebDriver.class))).thenThrow(new WebDriverException());
        baseInput.find(mock(WebDriver.class));
    }

    @Test
    public void testValid() throws Exception {
        baseInput.find(mock(WebDriver.class));
        verify(baseInput, times(1)).findElement(any(WebDriver.class));
    }
}