package lt.markmerkk;

import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class SimpleFilter implements PageFilter {

    WebDriver driver;
    WPage page;

    public SimpleFilter(WebDriver driver, WPage page) {
        this.driver = driver;
        this.page = page;
    }

    @Override
    public void fillIn() {

    }
}
