package lt.markmerkk.web_form_components;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mariusmerkevicius on 9/4/15.
 * A concrete button web element input component implementation
 */
public class WCButton extends WCBaseInput {

    private final Logger logger;

    // Button does not need a value input
    public WCButton(String name, String path) {
        super(name, path, null);
        logger = LoggerFactory.getLogger(WCButton.class);
    }

    @Override
    public void fill(WebElement element) throws WebDriverException, IllegalArgumentException {
        if (element == null)
            return;
        element.click();
    }

}
