package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.PageInspector;
import lt.markmerkk.interfaces.page.WPage;
import lt.markmerkk.interfaces.WebRunner;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
public class SimpleWebRunner implements WebRunner {

    final WebDriver driver;
    final WPage page;
    final PageFilter filter;
    final PageInspector inspector;
    private final Logger logger;

    @Inject
    public SimpleWebRunner(WebDriver driver, WPage page, PageFilter filter, PageInspector inspector) {
        logger = LoggerFactory.getLogger(SimpleWebRunner.class);
        this.driver = driver;
        this.page = page;
        this.filter = filter;
        this.inspector = inspector;
    }

    @Override
    public void run() {
        if (page.url() == null) {
            logger.error("No url specified!");
            driver.quit();
            return;
        }

        driver.get(page.url());
        filter.fillFilterForm();
        inspector.inspect();
        driver.quit();
    }

}
