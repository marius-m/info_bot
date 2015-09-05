package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebInputComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

/**
 * Created by mariusmerkevicius on 9/5/15.
 * A base abstract class that represents component data that is
 * used for filling in user input.
 */
public abstract class WCBaseInput implements WebInputComponent {
    private final Logger logger;
    final String name;
    final String path;
    final String value;

    public WCBaseInput(String name, String path, String value) {
        if (path == null)
            throw new IllegalArgumentException("Define xpath!");
        if (name == null)
            throw new IllegalArgumentException("Define name!");
        logger = LoggerFactory.getLogger(getClass());
        this.name = name;
        this.path = path;
        this.value = value;
    }

    @Override
    public WebElement find(WebDriver driver) throws NoSuchElementException, IllegalArgumentException {
        if (driver == null)
            throw new IllegalArgumentException("Web driver is null!");
        logger.debug("Looking for " + name + " component with \"" + value + "\" value.");
        return findElement(driver);
    }

    @Override
    public void fill(WebElement element) throws WebDriverException, IllegalArgumentException {
        if (element == null)
            throw new IllegalArgumentException("Error getting element to fill in!");
        logger.debug("Filling " + name + " component with \"" + value + "\" value.");
    }

    @Override
    public String xpath() {
        return path;
    }

    @Override
    public String name() {
        return name;
    }

    //region Abstract

    /**
     * Wrapped function for passing dependency to its children to find elements
     * This method will *NEVER* pass in null parameters
     *
     * @param driver provided driver
     * @return found element, or exception is thrown
     * @throws NoSuchElementException
     * @throws IllegalArgumentException
     */
    abstract WebElement findElement(WebDriver driver) throws NoSuchElementException, IllegalArgumentException ;

    /**
     * Wrapped function to pass dependency to its children to fill in elements
     * This method will *NEVER* pass in null parameters
     *
     * @param element provided web element. This will never be null
     * @throws WebDriverException
     * @throws IllegalArgumentException
     */
    abstract void fillElement(WebElement element)  throws WebDriverException, IllegalArgumentException;

    //endregion

}
