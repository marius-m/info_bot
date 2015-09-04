package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebComponentBase;
import lt.markmerkk.web_components.interfaces.WebComponentText;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

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
        logger.info("Executing query");
        logger.debug("Looking for available components...");
        HashMap<String, WebComponentBase> components = page.filterComponents();
        if (components == null)
            return;
        for (String componentName : components.keySet()) {
            logger.debug("Looking for component " + componentName);
            WebComponentBase componentDetail = components.get(componentName);
            fillComponent(findComponent(componentDetail), componentDetail);
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
        if (componentDetail instanceof WebComponentText) {
            String text = ((WebComponentText) componentDetail).text();
            logger.debug("Filling in with " + text);
            element.clear();
            element.sendKeys(text);
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
            return driver.findElement(By.xpath(componentDetail.path()));
        } catch (NoSuchElementException e) {
            logger.error("Error getting component! Path: " + componentDetail.path());
        } catch (IllegalArgumentException e) {
            logger.error("Error getting component! Path: " + componentDetail.path() + ". " + e.getMessage());
        }
        return null;
    }

}
