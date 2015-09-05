package lt.markmerkk;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import org.openqa.selenium.WebDriver;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SimpleWebRunner_Factory implements Factory<SimpleWebRunner> {
  private final Provider<WebDriver> driverProvider;
  private final Provider<WPage> pageProvider;
  private final Provider<PageFilter> filterProvider;

  public SimpleWebRunner_Factory(Provider<WebDriver> driverProvider, Provider<WPage> pageProvider, Provider<PageFilter> filterProvider) {  
    assert driverProvider != null;
    this.driverProvider = driverProvider;
    assert pageProvider != null;
    this.pageProvider = pageProvider;
    assert filterProvider != null;
    this.filterProvider = filterProvider;
  }

  @Override
  public SimpleWebRunner get() {  
    return new SimpleWebRunner(driverProvider.get(), pageProvider.get(), filterProvider.get());
  }

  public static Factory<SimpleWebRunner> create(Provider<WebDriver> driverProvider, Provider<WPage> pageProvider, Provider<PageFilter> filterProvider) {  
    return new SimpleWebRunner_Factory(driverProvider, pageProvider, filterProvider);
  }
}

