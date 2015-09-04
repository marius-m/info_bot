package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

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
        logger.debug("Looking for available components...");
        List<WebComponentBase> components = page.filterComponents();
        if (components == null)
            return;
        for (WebComponentBase component : components) {
            logger.debug("Looking for component " + component.name());
            fillComponent(findComponent(component), component);
        }
    }

    /**
     * Fills in component with details from the {@link WebComponentBase}
     * concrete implementation
     * @param element web element that will be manipulated
     * @param componentDetail element detail
     */
    void fillComponent(WebElement element, WebComponentBase componentDetail) {
        if (element == null)
            return;
        if (componentDetail == null)
            return;
        try {
            componentDetail.fillIn(element);
        } catch (WebDriverException e) {
            logger.error("Error filling data. (" + e.getMessage() + ")" );
        } catch (IllegalArgumentException e) {
            logger.error("Error filling data. (" + e.getMessage() + ")" );
        }
    }

    /**
     * Looks for a component using web driver.
     * Internally handles {@link NoSuchElementException}.
     *
     * @param componentDetail component detailed path
     * @return null if component not available. Otherwise component path
     */
    WebElement findComponent(WebComponentBase componentDetail) {
        if (componentDetail == null)
            return null;
        try {
            return driver.findElement(By.xpath(componentDetail.xpath()));
        } catch (NoSuchElementException e) {
            logger.error("Error getting component! Path: " + componentDetail.xpath());
        } catch (IllegalArgumentException e) {
            logger.error("Error getting component! Path: " + componentDetail.xpath() + ". " + e.getMessage());
        }
        return null;
    }

}
