package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
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
    public void fillIn() {
        logger.info("Executing filter");
        List<WebInputComponent> components = page.filterComponents();
        if (components == null)
            return;
        for (WebInputComponent component : components)
            try {
                component.fill(component.find(driver));
            } catch (NoSuchElementException e) {
                logger.debug(e.getMessage());
            } catch (WebDriverException e) {
                logger.debug(e.getMessage());
            } catch (IllegalArgumentException e) {
                logger.debug(e.getMessage());
            }
    }

}
