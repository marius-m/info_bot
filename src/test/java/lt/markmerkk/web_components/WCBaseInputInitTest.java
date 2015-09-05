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

            @Override
            WebElement findElement(WebDriver driver) throws NoSuchElementException, IllegalArgumentException {
                return null;
            }

            @Override
            void fillElement(WebElement element) throws WebDriverException, IllegalArgumentException {

            }
        };
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPath() throws Exception {
        new WCBaseInput("asdf", null, "asdf") {

            @Override
            WebElement findElement(WebDriver driver) throws NoSuchElementException, IllegalArgumentException {
                return null;
            }

            @Override
            void fillElement(WebElement element) throws WebDriverException, IllegalArgumentException {

            }
        };
    }

    @Test // Value parameter can be skipped, though when executing it might throw illegal argument if its needed
    public void testNullValue() throws Exception {
        new WCBaseInput("asdf", "//someXpath", null) {

            @Override
            WebElement findElement(WebDriver driver) throws NoSuchElementException, IllegalArgumentException {
                return null;
            }

            @Override
            void fillElement(WebElement element) throws WebDriverException, IllegalArgumentException {

            }
        };
    }

    @Test
    public void testValidCreation() throws Exception {
        assertNotNull(new WCBaseInput("asdf", "//someXpath", "asdf") {

            @Override
            WebElement findElement(WebDriver driver) throws NoSuchElementException, IllegalArgumentException {
                return null;
            }

            @Override
            void fillElement(WebElement element) throws WebDriverException, IllegalArgumentException {

            }
        });
    }

}