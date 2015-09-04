package lt.markmerkk.web_components;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mariusmerkevicius on 9/4/15.
 * A concrete text web element input component implementation
 */
public class WCText extends WCBaseInput {

    private final Logger logger;

    public WCText(String name, String path, String value) {
        super(name, path, value);
        if (value == null)
            throw new IllegalArgumentException("This component type cannot function properly without a value!");
        logger = LoggerFactory.getLogger(WCText.class);
    }

    @Override
    public void fillIn(WebElement element) throws WebDriverException, IllegalArgumentException {
        if (element == null)
            return;
        logger.debug("Filling " + name + "component with \"" + value + "\"");
        element.clear();
        element.sendKeys(value);
    }

}
