package lt.markmerkk.modules;

import dagger.internal.Factory;
import javax.annotation.Generated;
import lt.markmerkk.interfaces.WPage;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class SimpleWebRunnerModule_ProvidesPageFactory implements Factory<WPage> {
  private final SimpleWebRunnerModule module;

  public SimpleWebRunnerModule_ProvidesPageFactory(SimpleWebRunnerModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public WPage get() {  
    WPage provided = module.providesPage();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<WPage> create(SimpleWebRunnerModule module) {  
    return new SimpleWebRunnerModule_ProvidesPageFactory(module);
  }
}

