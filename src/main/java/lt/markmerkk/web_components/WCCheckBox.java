package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebComponentBase;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mariusmerkevicius on 9/4/15.
 * A concrete checkbox web element input component implementation
 */
public class WCCheckBox implements WebComponentBase {

    private final Logger logger;
    String path;
    String value;

    public WCCheckBox(String path, String value) {
        if (path == null)
            throw new IllegalArgumentException("Xpath must be defined!");
        this.path = path;
        if (value == null)
            throw new IllegalArgumentException("Value must be defined!");
        logger = LoggerFactory.getLogger(WCCheckBox.class);
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
        logger.debug("Selecting in "+getClass().getSimpleName()+" component with \""+value+"\"");
        element.sendKeys(value);
    }

}
