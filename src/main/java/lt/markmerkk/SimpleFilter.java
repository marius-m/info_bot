package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleFilter implements PageFilter {

    WebDriver driver;
    WPage page;

    public SimpleFilter(WebDriver driver, WPage page) {
        if (driver == null)
            throw new IllegalArgumentException("Filter cannot function without web driver");
        if (page == null)
            throw new IllegalArgumentException("Filter cannot function without page info");
        this.driver = driver;
        this.page = page;
    }

    @Override
    public void fillIn() {
        HashMap<String, WebComponentBase> components = page.filterComponents();
        findAvailableComponents(components);
    }

    private void findAvailableComponents(HashMap<String, WebComponentBase> components) {
        HashMap<String, WebComponentBase> validComponents = new HashMap<String, WebComponentBase>();
        for (WebComponentBase s : components.values()) {
            try {
                WebElement element = driver.findElement(By.xpath(s.path()));
            } catch (NoSuchElementException e) {

            }

        }
    }
}
