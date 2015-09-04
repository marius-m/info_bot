package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

/**
 * Created by mariusmerkevicius on 9/4/15.
 * Tests out {@link SimpleFilter#findComponent(WebComponentBase)}
 * method and its cases
 */
public class SimpleFilterFindElementTest {

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
    public void testNullDetail() throws Exception {
        assertNull(filter.findComponent(null));
    }

    @Test
    public void testNullPath() throws Exception {
        assertNull(filter.findComponent(new WebComponentBase() {
            @Override
            public String xpath() {
                return null;
            }

            @Override
            public void fillIn(WebElement element) throws WebDriverException {

            }
        }));
    }

    @Test
    public void testNullEmptyPath() throws Exception {
        assertNull(filter.findComponent(new WebComponentBase() {
            @Override
            public String xpath() {
                return "";
            }

            @Override
            public void fillIn(WebElement element) throws WebDriverException {

            }
        }));
    }

    @Test
    public void testValidPath() throws Exception {
        WebElement webElement = mock(WebElement.class);
        when(filter.driver.findElement(any(By.class))).thenReturn(webElement);
        assertNotNull(filter.findComponent(new WebComponentBase() {
            @Override
            public String xpath() {
                return "//somePath";
            }

            @Override
            public void fillIn(WebElement element) throws WebDriverException {

            }
        }));;
    }

    @Test
    public void testThrowsNoSuchElement() throws Exception {
        when(filter.driver.findElement(any(By.class))).thenThrow(new NoSuchElementException("No such element"));
        assertNull(filter.findComponent(new WebComponentBase() {
            @Override
            public String xpath() {
                return "//somePath";
            }

            @Override
            public void fillIn(WebElement element) throws WebDriverException {

            }
        }));;
    }

}