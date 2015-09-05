package lt.markmerkk.components;

import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import lt.markmerkk.SimpleWebRunner;
import lt.markmerkk.SimpleWebRunner_Factory;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.modules.SimpleWebRunnerModule;
import lt.markmerkk.modules.SimpleWebRunnerModule_ProvidesPageFactory;
import lt.markmerkk.modules.SimpleWebRunnerModule_ProvidesPageFilterFactory;
import lt.markmerkk.modules.SimpleWebRunnerModule_ProvidesWebDriverFactory;
import org.openqa.selenium.WebDriver;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerSimpleWebRunnerComponent implements SimpleWebRunnerComponent {
  private Provider<WebDriver> providesWebDriverProvider;
  private Provider<WPage> providesPageProvider;
  private Provider<PageFilter> providesPageFilterProvider;
  private Provider<SimpleWebRunner> simpleWebRunnerProvider;

  private DaggerSimpleWebRunnerComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  public static SimpleWebRunnerComponent create() {  
    return builder().build();
  }

  private void initialize(final Builder builder) {  
    this.providesWebDriverProvider = ScopedProvider.create(SimpleWebRunnerModule_ProvidesWebDriverFactory.create(builder.simpleWebRunnerModule));
    this.providesPageProvider = ScopedProvider.create(SimpleWebRunnerModule_ProvidesPageFactory.create(builder.simpleWebRunnerModule));
    this.providesPageFilterProvider = SimpleWebRunnerModule_ProvidesPageFilterFactory.create(builder.simpleWebRunnerModule, providesWebDriverProvider, providesPageProvider);
    this.simpleWebRunnerProvider = SimpleWebRunner_Factory.create(providesWebDriverProvider, providesPageProvider, providesPageFilterProvider);
  }

  @Override
  public SimpleWebRunner maker() {  
    return simpleWebRunnerProvider.get();
  }

  public static final class Builder {
    private SimpleWebRunnerModule simpleWebRunnerModule;
  
    private Builder() {  
    }
  
    public SimpleWebRunnerComponent build() {  
      if (simpleWebRunnerModule == null) {
        this.simpleWebRunnerModule = new SimpleWebRunnerModule();
      }
      return new DaggerSimpleWebRunnerComponent(this);
    }
  
    public Builder simpleWebRunnerModule(SimpleWebRunnerModule simpleWebRunnerModule) {  
      if (simpleWebRunnerModule == null) {
        throw new NullPointerException("simpleWebRunnerModule");
      }
      this.simpleWebRunnerModule = simpleWebRunnerModule;
      return this;
    }
  }
}

