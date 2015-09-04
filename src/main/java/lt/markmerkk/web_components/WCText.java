package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public class WCText implements WebComponentBase {

    private final Logger logger;
    String path;
    String value;

    public WCText(String path, String value) {
        if (path == null)
            throw new IllegalArgumentException("Xpath must be defined!");
        this.path = path;
        if (value == null)
            throw new IllegalArgumentException("Value must be defined!");
        logger = LoggerFactory.getLogger(WCText.class);
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
        logger.debug("Filling in "+getClass().getSimpleName()+" component with \""+value+"\"");
        element.clear();
        element.sendKeys(value);
    }

}
