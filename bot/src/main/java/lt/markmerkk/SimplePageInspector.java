package lt.markmerkk;

import lt.markmerkk.interfaces.PageInspector;
import lt.markmerkk.interfaces.WPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
public class SimplePageInspector implements PageInspector {

    WebDriver driver;

    public SimplePageInspector(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void inspect(WPage page) {

    }
}