package lt.markmerkk.modules;

import dagger.Module;
import dagger.Provides;
import lt.markmerkk.SimpleFilter;
import lt.markmerkk.PageAruodas;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.inject.Singleton;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
@Module
public class SimpleWebRunnerModule {

    @Provides
    @Singleton
    WebDriver providesWebDriver() {
        return new FirefoxDriver();
    }

    @Provides
    @Singleton
    WPage providesPage() {
        return new PageAruodas();
    }

    @Provides
    PageFilter providesPageFilter(WebDriver driver, WPage page) {
        return new SimpleFilter(driver, page);
    }

}
