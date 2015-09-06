package lt.markmerkk;

import lt.markmerkk.interfaces.PageInspector;
import lt.markmerkk.interfaces.page.WPageResultSearchable;
import org.openqa.selenium.WebDriver;

/**
 * Created by mariusmerkevicius on 9/2/15.
 * Class that inspects pulled information with provided searchable config
 * to traverse data
 */
public class SimplePageInspector implements PageInspector {

    final WPageResultSearchable page;
    final WebDriver driver;

    public SimplePageInspector(WebDriver driver, WPageResultSearchable page) {
        this.driver = driver;
        this.page = page;
    }

    @Override
    public void inspect() {

    }
}
