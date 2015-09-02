package lt.markmerkk.components;

import dagger.Component;
import lt.markmerkk.SimpleWebRunner;
import lt.markmerkk.modules.SimpleWebRunnerModule;

/**
 * Created by mariusmerkevicius on 9/2/15.
 */
@Component(modules = {SimpleWebRunnerModule.class})
public interface SimpleWebRunnerComponent {
    SimpleWebRunner maker();
}
