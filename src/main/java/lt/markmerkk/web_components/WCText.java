package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.openqa.selenium.WebElement;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class WCText implements WebComponentBase {

    String path;
    String value;

    public WCText(String path, String value) {
        if (path == null)
            throw new IllegalArgumentException("Xpath must be defined!");
        this.path = path;
        if (value == null)
            throw new IllegalArgumentException("Value must be defined!");
        this.value = value;
    }

    @Override
    public String xpath() {
        return path;
    }

    @Override
    public void fillIn(WebElement element) {
        if (element == null)
            return;
        element.clear();
        element.sendKeys(value);
    }

}
