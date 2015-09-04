package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.WCText;
import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleFilterFilterTest {

    private WebDriver webDriver;
    private WPage page;
    private SimpleFilter filter;

    @Before
    public void setUp() throws Exception {
        webDriver = mock(WebDriver.class);
        page = mock(WPage.class);
        filter = spy(new SimpleFilter(webDriver, page));
    }

    @Test
    public void testNullFilterElements() throws Exception {
        filter.fillIn();
        // When components are empty, it should not call any methods on the driver
        verify(webDriver, never()).findElement(any(By.class));
        verify(webDriver, never()).findElements(any(By.class));
    }

    @Test
    public void testEmptyFilterElements() throws Exception {
        when(page.filterComponents()).thenReturn(new HashMap<String, WebComponentBase>());
        filter.fillIn();
        // When components are empty, it should not call any methods on the driver
        verify(filter, never()).findComponent(any(WebComponentBase.class));
        verify(filter, never()).fillComponent(any(WebElement.class), any(WebComponentBase.class));
    }

}