package lt.markmerkk.interfaces;

import lt.markmerkk.interfaces.page.WPage;

/**
 * Created by mariusmerkevicius on 9/2/15.
 * An inspector abstraction that is responsible for inspecting result
 */
public interface PageInspector {

    /**
     * A function that is executed when trying to inspect data that must be gathered.
     */
    void inspect();
}
