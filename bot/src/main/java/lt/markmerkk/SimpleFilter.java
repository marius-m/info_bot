package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebComponent;
import lt.markmerkk.web_components.interfaces.WebInputComponent;
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
        List<WebComponent> components = page.filterComponents();
        if ((components != null && components.size() == 0) || components == null)
            logger.info("No filter components specified!");
        if (components == null)
            return;
        for (WebComponent component : components) {
            if (!(component instanceof WebInputComponent))
                continue;
            WebInputComponent inputComponent = (WebInputComponent) component;
            try {
                inputComponent.fill(inputComponent.find(driver));
            } catch (NoSuchElementException e) {
                logger.debug(e.getMessage());
            } catch (WebDriverException e) {
                logger.debug(e.getMessage());
            } catch (IllegalArgumentException e) {
                logger.debug(e.getMessage());
            }
        }
    }

}
