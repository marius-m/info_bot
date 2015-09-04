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
     * Represents component name
     * @return
     */
    String name();

    /**
     * Path that is used to find the component
     * @return provides the used xpath
     */
    String xpath();

    /**
     * Takes in provided web element and executes query to the element
     * @param element provided web element
     * @throws WebDriverException whenever there is a problem executing function on the {@link WebElement}
     * @throws IllegalArgumentException whenever there is a problem with input parameters
     */
    void fillIn(WebElement element) throws WebDriverException, IllegalArgumentException;
}
