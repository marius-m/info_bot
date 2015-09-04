package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
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
        SimpleFilter filter = new SimpleFilter(null, mock(WPage.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullWPage() throws Exception {
        SimpleFilter filter = new SimpleFilter(mock(WebDriver.class), null);
    }

    //endregion



}