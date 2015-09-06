package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebFormComponent;
import lt.markmerkk.web_components.interfaces.WebFormInputComponent;
import lt.markmerkk.web_components.interfaces.WebFormSupportComponent;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by mariusmerkevicius on 9/7/15.
 */
public class SimpleFilterInputComponentHandlingTest {

    private SimpleFilter filter;

    @Before
    public void setUp() throws Exception {
        filter = new SimpleFilter(mock(WebDriver.class), mock(WPage.class));
    }

    @Test
    public void testNull() throws Exception {
        assertFalse(filter.handleInputComponent(null));
    }

    @Test
    public void testGenralType() throws Exception {
        assertFalse(filter.handleInputComponent(mock(WebFormComponent.class)));
    }

    @Test
    public void testWrongType() throws Exception {
        assertFalse(filter.handleInputComponent(mock(WebFormSupportComponent.class)));
    }

    @Test
    public void testRightType() throws Exception {
        assertTrue(filter.handleInputComponent(mock(WebFormInputComponent.class)));
    }
}