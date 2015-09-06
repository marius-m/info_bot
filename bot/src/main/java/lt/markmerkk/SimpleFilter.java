package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebFormComponent;
import lt.markmerkk.web_components.interfaces.WebFormInputComponent;
import lt.markmerkk.web_components.interfaces.WebFormSupportComponent;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleFilter implements PageFilter {

    WebDriver driver;
    WPage page;
    private final Logger logger;

    public SimpleFilter(WebDriver driver, WPage page) {
        logger = LoggerFactory.getLogger(SimpleFilter.class);
        if (driver == null)
            throw new IllegalArgumentException("Filter cannot function without web driver");
        if (page == null)
            throw new IllegalArgumentException("Filter cannot function without page info");
        this.driver = driver;
        this.page = page;
    }

    @Override
    public void fillFilterForm() {
        logger.info("Executing filter");
        List<WebFormComponent> components = page.filterComponents();
        if ((components != null && components.size() == 0) || components == null)
            logger.info("No filter components specified!");
        if (components == null)
            return;
        for (WebFormComponent component : components) {
            if (handleInputComponent(component))
                continue;
            if (handleSupportComponent(component))
                continue;
        }
    }

    //region Convenience

    /**
     * Function to handle {@link lt.markmerkk.web_components.interfaces.WebFormSupportComponent}
     * Returns false, if there was an error in handling component or provided component
     * was the wrong type.
     * @param component general component type to handle
     * @return true if component was handled successfully.
     */
    boolean handleSupportComponent(WebFormComponent component) {
        if (component == null)
            return false;
        if (!(component instanceof WebFormSupportComponent))
            return false;
        ((WebFormSupportComponent) component).exec();
        return true;
    }

    /**
     * Function to handle {@link WebFormInputComponent}
     * Returns false, if there was an error in handling component or provided component
     * was the wrong type.
     * @param component general component type to handle.
     * @return true if component was handled successfully.
     */
    boolean handleInputComponent(WebFormComponent component) {
        if (component == null)
            return false;
        if (!(component instanceof WebFormInputComponent))
            return false;
        WebFormInputComponent inputComponent = (WebFormInputComponent) component;
        try {
            inputComponent.fill(inputComponent.find(driver));
            return true;
        } catch (NoSuchElementException e) {
            logger.debug(e.getMessage());
        } catch (WebDriverException e) {
            logger.debug(e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.debug(e.getMessage());
        }
        return false;
    }

    //endregion

}
