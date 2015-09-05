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
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFillNullInput() throws Exception {
        baseInput.find(null);
    }

    @Test
    public void testValid() throws Exception {
        baseInput.find(mock(WebDriver.class));
    }
}