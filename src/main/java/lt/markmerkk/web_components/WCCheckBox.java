package lt.markmerkk.web_components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by mariusmerkevicius on 9/4/15.
 * A concrete checkbox web element input component implementation
 */
public class WCCheckBox extends WCBaseInput {
    public WCCheckBox(String name, String path, String value) {
        super(name, path, value);
        if (value == null)
            throw new IllegalArgumentException("This component type cannot function properly without a value!");
    }

}
