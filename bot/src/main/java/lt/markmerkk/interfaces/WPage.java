package lt.markmerkk.interfaces;

import lt.markmerkk.web_form_components.interfaces.WebFormComponent;

import java.util.List;

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
    List<WebFormComponent> filterComponents();
}
