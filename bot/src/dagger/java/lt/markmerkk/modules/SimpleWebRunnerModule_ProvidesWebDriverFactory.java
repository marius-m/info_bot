package lt.markmerkk.modules;

import dagger.internal.Factory;
import javax.annotation.Generated;
import org.openqa.selenium.WebDriver;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SimpleWebRunnerModule_ProvidesWebDriverFactory implements Factory<WebDriver> {
  private final SimpleWebRunnerModule module;

  public SimpleWebRunnerModule_ProvidesWebDriverFactory(SimpleWebRunnerModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public WebDriver get() {  
    WebDriver provided = module.providesWebDriver();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<WebDriver> create(SimpleWebRunnerModule module) {  
    return new SimpleWebRunnerModule_ProvidesWebDriverFactory(module);
  }
}

