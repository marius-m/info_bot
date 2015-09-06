package lt.markmerkk;

import lt.markmerkk.interfaces.page.WPage;
import lt.markmerkk.interfaces.page.WPageFilterable;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleFilterInitTest {

    //region Test out initialization

    @Test(expected = IllegalArgumentException.class)
    public void testNullWebDriver() throws Exception {
        SimpleFilter filter = new SimpleFilter(null, mock(WPageFilterable.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullWPage() throws Exception {
        SimpleFilter filter = new SimpleFilter(mock(WebDriver.class), null);
    }

    @Test
    public void testValid() throws Exception {
        SimpleFilter filter = new SimpleFilter(mock(WebDriver.class), mock(WPageFilterable.class));
        assertNotNull(filter);
    }

    //endregion



}