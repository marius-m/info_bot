package lt.markmerkk.components;

import dagger.Component;
import lt.markmerkk.SimpleWebRunner;
import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.modules.SimpleWebRunnerModule;

import javax.inject.Singleton;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
@Component(modules = SimpleWebRunnerModule.class)
@Singleton
public interface SimpleWebRunnerComponent {
    SimpleWebRunner runner();
}
