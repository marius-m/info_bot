package lt.markmerkk.modules;

import com.google.inject.Singleton;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import lt.markmerkk.FilterAruodas;
import lt.markmerkk.PageAruodas;
import lt.markmerkk.SimpleWebRunner;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
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

    @Provides
    WPage providesPage() {
        return new PageAruodas();
    }

    @Provides
    PageFilter providesPageFilter() {
        return new FilterAruodas();
    }

}
