package lt.markmerkk;

import lt.markmerkk.interfaces.page.WPage;
import lt.markmerkk.interfaces.page.WPageFilterable;
import lt.markmerkk.web_form_components.interfaces.WebFormComponent;
import lt.markmerkk.web_form_components.interfaces.WebFormInputComponent;
import lt.markmerkk.web_form_components.interfaces.WebFormSupportComponent;
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
    private WPageFilterable page;
    private SimpleFilter filter;

    @Before
    public void setUp() throws Exception {
        webDriver = mock(WebDriver.class);
        page = mock(WPageFilterable.class);
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
        when(page.filterComponents()).thenReturn(new ArrayList<WebFormComponent>());
        filter.fillFilterForm();
        verify(webDriver, never()).findElement(any(By.class));
        verify(webDriver, never()).findElements(any(By.class));
    }

    @Test
    public void testOneFilterComponent() throws Exception {
        ArrayList<WebFormComponent> webFormComponents = new ArrayList<WebFormComponent>() {{
            add(mock(WebFormInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webFormComponents);
        filter.fillFilterForm();
        verify(toInput(webFormComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(0)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testManyFilterComponents() throws Exception {
        ArrayList<WebFormComponent> webFormComponents = new ArrayList<WebFormComponent>() {{
            add(mock(WebFormInputComponent.class));
            add(mock(WebFormInputComponent.class));
            add(mock(WebFormInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webFormComponents);
        filter.fillFilterForm();

        for (WebFormComponent webFormComponent : webFormComponents) {
            verify(toInput(webFormComponent), times(1)).find(any(WebDriver.class));
            verify(toInput(webFormComponent), times(1)).fill(any(WebElement.class));
        }
    }

    @Test
    public void testNoSuchElement() throws Exception {
        ArrayList<WebFormComponent> webFormComponents = new ArrayList<WebFormComponent>() {{
            add(mock(WebFormInputComponent.class));
            WebFormInputComponent noSuchElement = mock(WebFormInputComponent.class);
            when(noSuchElement.find(any(WebDriver.class))).thenThrow(new NoSuchElementException("Element was not found"));
            add(noSuchElement);
            add(mock(WebFormInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webFormComponents);
        filter.fillFilterForm();

        verify(toInput(webFormComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webFormComponents.get(1)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(1)), never()).fill(any(WebElement.class));
        verify(toInput(webFormComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testWebDriverErrorWhenFinding() throws Exception {
        ArrayList<WebFormComponent> webFormComponents = new ArrayList<WebFormComponent>() {{
            add(mock(WebFormInputComponent.class));
            WebFormInputComponent webDriverErrorElement = mock(WebFormInputComponent.class);
            when(webDriverErrorElement.find(any(WebDriver.class))).thenThrow(new WebDriverException());
            add(webDriverErrorElement);
            add(mock(WebFormInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webFormComponents);
        filter.fillFilterForm();

        verify(toInput(webFormComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webFormComponents.get(1)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(1)), never()).fill(any(WebElement.class));
        verify(toInput(webFormComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testWebDriverErrorWhenFilling() throws Exception {
        ArrayList<WebFormComponent> webFormComponents = new ArrayList<WebFormComponent>() {{
            add(mock(WebFormInputComponent.class));
            WebFormInputComponent webDriverErrorElement = mock(WebFormInputComponent.class);
            doThrow(new WebDriverException()).when(webDriverErrorElement).fill(any(WebElement.class));
            add(webDriverErrorElement);
            add(mock(WebFormInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webFormComponents);
        filter.fillFilterForm();

        verify(toInput(webFormComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webFormComponents.get(1)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(1)), times(1)).fill(any(WebElement.class));
        verify(toInput(webFormComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testMixedComponentsInTheList() throws Exception {
        ArrayList<WebFormComponent> webFormComponents = new ArrayList<WebFormComponent>() {{
            add(mock(WebFormInputComponent.class));
            add(mock(WebFormComponent.class));
            add(mock(WebFormInputComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webFormComponents);
        filter.fillFilterForm();

        verify(toInput(webFormComponents.get(0)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(0)), times(1)).fill(any(WebElement.class));
        verify(toInput(webFormComponents.get(2)), times(1)).find(any(WebDriver.class));
        verify(toInput(webFormComponents.get(2)), times(1)).fill(any(WebElement.class));
    }

    @Test
    public void testMixedComponentsExecutionInTheList() throws Exception {
        ArrayList<WebFormComponent> webFormComponents = new ArrayList<WebFormComponent>() {{
            add(mock(WebFormInputComponent.class));
            add(mock(WebFormComponent.class));
            add(mock(WebFormInputComponent.class));
            add(mock(WebFormComponent.class));
            add(mock(WebFormSupportComponent.class));
            add(mock(WebFormComponent.class));
            add(mock(WebFormSupportComponent.class));
        }};
        when(page.filterComponents()).thenReturn(webFormComponents);
        filter.fillFilterForm();

        // Verify the right component execution
        for (WebFormComponent webFormComponent : webFormComponents) {
            if (webFormComponent instanceof WebFormInputComponent) {
                verify(((WebFormInputComponent) webFormComponent), times(1)).find(any(WebDriver.class));
                verify(((WebFormInputComponent) webFormComponent), times(1)).fill(any(WebElement.class));
                continue;
            }
            if (webFormComponent instanceof WebFormSupportComponent)
                verify(((WebFormSupportComponent) webFormComponent), times(1)).exec();
        }
    }

    //region Convenience methods

    public static WebFormInputComponent toInput(WebFormComponent component) {
        return (WebFormInputComponent) component;
    }

    //endregion

}