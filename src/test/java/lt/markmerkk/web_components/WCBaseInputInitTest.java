package lt.markmerkk.web_components;

import org.junit.Test;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCBaseInputInitTest {
    @Test
    public void testName() throws Exception {


    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPath() throws Exception {
        new WCBaseInput(null, "asdf") {

            @Override
            public void fillIn(WebElement element) throws WebDriverException {

            }
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullValue() throws Exception {
        new WCBaseInput("//someXpath", null) {

            @Override
            public void fillIn(WebElement element) throws WebDriverException {

            }
        };
    }

    @Test
    public void testValidCreation() throws Exception {
        assertNotNull(new WCBaseInput("//someXpath", "asdf") {

            @Override
            public void fillIn(WebElement element) throws WebDriverException {

            }
        });
    }

}