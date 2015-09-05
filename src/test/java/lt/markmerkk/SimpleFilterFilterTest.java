package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebInputComponent;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import java.util.ArrayList;

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
        verify(webDriver, never()).findElement(any(By.class));
        verify(webDriver, never()).findElements(any(By.class));
    }

    @Test
    public void testEmptyFilterElements() throws Exception {
        when(page.filterComponents()).thenReturn(new ArrayList<WebInputComponent>());
        filter.fillIn();
        verify(webDriver, never()).findElement(any(By.class));
        verify(webDriver, never()).findElements(any(By.class));
    }

    @Test
    public void testOneFilterComponent() throws Exception {
        ArrayList<WebInputComponent> webComponents = new ArrayList<WebInputComponent>() {{
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillIn();
        verify(webComponents.get(0), times(1)).find(any(WebDriver.class));
        verify(webComponents.get(0), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testManyFilterComponents() throws Exception {
        ArrayList<WebInputComponent> webComponents = new ArrayList<WebInputComponent>() {{
            add(mock(WebInputComponent.class));
            add(mock(WebInputComponent.class));
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillIn();

        for (WebInputComponent webComponent : webComponents) {
            verify(webComponent, times(1)).find(any(WebDriver.class));
            verify(webComponent, times(1)).fill(any(WebElement.class));
        }
    }
}