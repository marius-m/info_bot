package lt.markmerkk.modules;

import dagger.Module;
import dagger.Provides;
import lt.markmerkk.SimpleFilter;
import lt.markmerkk.SimplePageInspector;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.PageInspector;
import lt.markmerkk.interfaces.page.WPage;
import lt.markmerkk.interfaces.page.WPageFilterable;
import lt.markmerkk.interfaces.page.WPageResultSearchable;
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
    private final WPageResultSearchable resultSearchable;

    public WebRunnerModule(WPage page, WPageFilterable filterable, WPageResultSearchable resultSearchable) {
        this.page = page;
        this.pageFilterable = filterable;
        this.resultSearchable = resultSearchable;
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

    @Provides
    PageInspector providesPageInspector(WebDriver driver) {
        return new SimplePageInspector(driver, resultSearchable);
    }

}
