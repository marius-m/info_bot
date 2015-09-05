package lt.markmerkk.web_components;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCBaseInputInitTest {
    @Test
    public void testName() throws Exception {


    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() throws Exception {
        new WCBaseInput(null, "//asdf", "asdf") {
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPath() throws Exception {
        new WCBaseInput("asdf", null, "asdf") {
        };
    }

    @Test // Value parameter can be skipped, though when executing it might throw illegal argument if its needed
    public void testNullValue() throws Exception {
        new WCBaseInput("asdf", "//someXpath", null) {
        };
    }

    @Test
    public void testValidCreation() throws Exception {
        assertNotNull(new WCBaseInput("asdf", "//someXpath", "asdf") {
        });
    }

}