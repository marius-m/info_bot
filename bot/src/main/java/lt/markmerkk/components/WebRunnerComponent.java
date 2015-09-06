package lt.markmerkk.components;

import dagger.Component;
import lt.markmerkk.SimpleWebRunner;
import lt.markmerkk.modules.WebRunnerModule;

import javax.inject.Singleton;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
@Component(modules = WebRunnerModule.class)
@Singleton
public interface WebRunnerComponent {
    SimpleWebRunner runner();
}
