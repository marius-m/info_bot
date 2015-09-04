package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.WCText;
import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by mariusmerkevicius on 9/5/15.
 * Tests out {@link SimpleFilter#fillComponent(WebElement, WebComponentBase)}
 * method and its cases
 */
public class SimpleFilterFillElementTest {
    private WebDriver webDriver;
    private WPage page;
    private SimpleFilter filter;

    @Before
    public void setUp() throws Exception {
        webDriver = mock(WebDriver.class);
        page = mock(WPage.class);
        filter = new SimpleFilter(webDriver, page);
    }

    @Test // Should not do anything
    public void testNullElement() throws Exception {
        filter.fillComponent(null, mock(WebComponentBase.class));
    }

    @Test
    public void testNullDetail() throws Exception {
        filter.fillComponent(mock(WebElement.class), null);
    }

    @Test
    public void testValidTextElement() throws Exception {
        WebElement webElement = mock(WebElement.class);
        WebComponentBase textComponent = mock(WCText.class);
        filter.fillComponent(webElement, textComponent);
        verify(webElement, times(1)).clear();
        verify(webElement, times(1)).sendKeys(any(String.class));
    }
}