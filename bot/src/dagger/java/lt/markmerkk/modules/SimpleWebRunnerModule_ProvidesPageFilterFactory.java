package lt.markmerkk.modules;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import org.openqa.selenium.WebDriver;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SimpleWebRunnerModule_ProvidesPageFilterFactory implements Factory<PageFilter> {
  private final SimpleWebRunnerModule module;
  private final Provider<WebDriver> driverProvider;
  private final Provider<WPage> pageProvider;

  public SimpleWebRunnerModule_ProvidesPageFilterFactory(SimpleWebRunnerModule module, Provider<WebDriver> driverProvider, Provider<WPage> pageProvider) {  
    assert module != null;
    this.module = module;
    assert driverProvider != null;
    this.driverProvider = driverProvider;
    assert pageProvider != null;
    this.pageProvider = pageProvider;
  }

  @Override
  public PageFilter get() {  
    PageFilter provided = module.providesPageFilter(driverProvider.get(), pageProvider.get());
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<PageFilter> create(SimpleWebRunnerModule module, Provider<WebDriver> driverProvider, Provider<WPage> pageProvider) {  
    return new SimpleWebRunnerModule_ProvidesPageFilterFactory(module, driverProvider, pageProvider);
  }
}

