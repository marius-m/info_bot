package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.WCText;
import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        filter = new SimpleFilter(webDriver, page);
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
        verify(webDriver, never()).findElement(any(By.class));
        verify(webDriver, never()).findElements(any(By.class));
    }

    @Test
    public void testOneElement() throws Exception {
        HashMap<String, WebComponentBase> filterComponents = new HashMap<String, WebComponentBase>();
        filterComponents.put("size_component", new WCText("//some_path", "fill_in_data"));
        when(page.filterComponents()).thenReturn(filterComponents);
        filter.fillIn();
        // When components are empty, it should not call any methods on the driver
        verify(webDriver, times(1)).findElement(any(By.class));
    }
}