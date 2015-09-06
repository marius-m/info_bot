package lt.markmerkk.modules;

import dagger.Module;
import dagger.Provides;
import lt.markmerkk.SimpleFilter;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.page.WPage;
import lt.markmerkk.interfaces.page.WPageFilterable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.inject.Singleton;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
@Module
public class WebRunnerModule {

    private final WPage page;
    private final WPageFilterable pageFilterable;

    public WebRunnerModule(WPage page, WPageFilterable filterable) {
        this.page = page;
        this.pageFilterable = filterable;
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
    PageFilter providesPageFilter(WebDriver driver) {
        return new SimpleFilter(driver, pageFilterable);
    }

}
