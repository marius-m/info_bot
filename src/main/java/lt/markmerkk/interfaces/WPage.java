package lt.markmerkk.interfaces;

import lt.markmerkk.web_components.interfaces.WebComponentBase;

import java.util.HashMap;

/**
 * Created by mariusmerkevicius on 9/2/15.
 * Page object abstraction
 */
public interface WPage {
    /**
     * Returns page url
     * @return
     */
    String url();

    /**
     * Returns filter components that should be filled before loading
     * list
     */
    HashMap<String, WebComponentBase> filterComponents();
}
