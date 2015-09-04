package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.interfaces.WebRunner;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
public class SimpleWebRunner implements WebRunner {

    final PageFilter filter;
    final WebDriver driver;
    final WPage page;

    @Inject
    public SimpleWebRunner(WebDriver driver, WPage page, PageFilter filter) {
        this.driver = driver;
        this.page = page;
        this.filter = filter;
    }

    @Override
    public void run() {
        driver.get(page.url());
        filter.fillIn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
