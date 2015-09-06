package lt.markmerkk.web_form_components;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Created by mariusmerkevicius on 9/4/15.
 * A concrete checkbox web element input component implementation
 */
public class WCCheckBox extends WCBaseInput {
    public WCCheckBox(String name, String path) {
        super(name, path, null);
    }

    @Override
    public void fill(WebElement element) throws WebDriverException, IllegalArgumentException {
        super.fill(element);
        element.click();
    }
}
