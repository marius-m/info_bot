package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebComponent;
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
        filter.fillFilterForm();
        verify(webDriver, never()).findElement(any(By.class));
        verify(webDriver, never()).findElements(any(By.class));
    }

    @Test
    public void testEmptyFilterElements() throws Exception {
        when(page.filterComponents()).thenReturn(new ArrayList<WebComponent>());
        filter.fillFilterForm();
        verify(webDriver, never()).findElement(any(By.class));
        verify(webDriver, never()).findElements(any(By.class));
    }

    @Test
    public void testOneFilterComponent() throws Exception {
        ArrayList<WebComponent> webComponents = new ArrayList<WebComponent>() {{
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillFilterForm();
        verify(toInput(webComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(0)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testManyFilterComponents() throws Exception {
        ArrayList<WebComponent> webComponents = new ArrayList<WebComponent>() {{
            add(mock(WebInputComponent.class));
            add(mock(WebInputComponent.class));
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillFilterForm();

        for (WebComponent webComponent : webComponents) {
            verify(toInput(webComponent), times(1)).find(any(WebDriver.class));
            verify(toInput(webComponent), times(1)).fill(any(WebElement.class));
        }
    }

    @Test
    public void testNoSuchElement() throws Exception {
        ArrayList<WebComponent> webComponents = new ArrayList<WebComponent>() {{
            add(mock(WebInputComponent.class));
            WebInputComponent noSuchElement = mock(WebInputComponent.class);
            when(noSuchElement.find(any(WebDriver.class))).thenThrow(new NoSuchElementException("Element was not found"));
            add(noSuchElement);
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillFilterForm();

        verify(toInput(webComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webComponents.get(1)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(1)), never()).fill(any(WebElement.class));
        verify(toInput(webComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testWebDriverErrorWhenFinding() throws Exception {
        ArrayList<WebComponent> webComponents = new ArrayList<WebComponent>() {{
            add(mock(WebInputComponent.class));
            WebInputComponent webDriverErrorElement = mock(WebInputComponent.class);
            when(webDriverErrorElement.find(any(WebDriver.class))).thenThrow(new WebDriverException());
            add(webDriverErrorElement);
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillFilterForm();

        verify(toInput(webComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webComponents.get(1)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(1)), never()).fill(any(WebElement.class));
        verify(toInput(webComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testWebDriverErrorWhenFilling() throws Exception {
        ArrayList<WebComponent> webComponents = new ArrayList<WebComponent>() {{
            add(mock(WebInputComponent.class));
            WebInputComponent webDriverErrorElement = mock(WebInputComponent.class);
            doThrow(new WebDriverException()).when(webDriverErrorElement).fill(any(WebElement.class));
            add(webDriverErrorElement);
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillFilterForm();

        verify(toInput(webComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webComponents.get(1)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(1)), times(1)).fill(any(WebElement.class));
        verify(toInput(webComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testMixedComponentsInTheList() throws Exception {
        ArrayList<WebComponent> webComponents = new ArrayList<WebComponent>() {{
            add(mock(WebInputComponent.class));
            add(mock(WebComponent.class));
            add(mock(WebInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webComponents);
        filter.fillFilterForm();

        verify(toInput(webComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    //region Convenience methods

    public static WebInputComponent toInput(WebComponent component) {
        return (WebInputComponent) component;
    }

    //endregion

}