package lt.markmerkk;

import org.openqa.selenium.WebDriver;

import javax.inject.Inject;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
public class SimpleWebRunner implements WebRunner {

    WebDriver driver;

    @Inject
    public SimpleWebRunner(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void run() {
        driver.quit();
    }

}
