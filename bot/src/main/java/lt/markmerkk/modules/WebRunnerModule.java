package lt.markmerkk.modules;

import dagger.Module;
import dagger.Provides;
import lt.markmerkk.SimpleFilter;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.inject.Singleton;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
@Module
public class WebRunnerModule {

    private final WPage page;

    public WebRunnerModule(WPage page) {
        this.page = page;
    }

    @Provides
    @Singleton
    WebDriver providesWebDriver() {
        return new FirefoxDriver();
    }

    @Provides
    @Singleton
    WPage providesPage() {
        return page;
    }

    @Provides
    PageFilter providesPageFilter(WebDriver driver, WPage page) {
        return new SimpleFilter(driver, page);
    }

}
