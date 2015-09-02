package lt.markmerkk.modules;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import lt.markmerkk.SimpleWebRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
@Module
public class SimpleWebRunnerModule {

    @Provides
    WebDriver providesWebDriver() {
        return new FirefoxDriver();
    }
}
