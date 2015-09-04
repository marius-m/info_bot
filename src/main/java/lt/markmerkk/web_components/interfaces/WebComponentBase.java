package lt.markmerkk.web_components.interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Created by mariusmerkevicius on 9/4/15.
 * An interface that describes component type and its functionality
 */
public interface WebComponentBase {
    /**
     * Path that is used to find the component
     * @return provides the used xpath
     */
    String xpath();

    /**
     * Takes in provided web element and executes query to the element
     * @param element provided web element
     */
    void fillIn(WebElement element) throws WebDriverException;
}
