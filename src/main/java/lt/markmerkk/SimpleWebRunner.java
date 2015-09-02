package lt.markmerkk;

import lt.markmerkk.interfaces.PageInspector;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.interfaces.WebRunner;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
public class SimpleWebRunner implements WebRunner {

    WebDriver driver;

    @Inject
    public SimpleWebRunner(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void run(WPage page, PageInspector inspector) {
        driver.get(page.pageUrl());
        driver.quit();
    }

}
