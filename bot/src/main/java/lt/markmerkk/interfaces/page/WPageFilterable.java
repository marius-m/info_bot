package lt.markmerkk.interfaces.page;

import lt.markmerkk.web_form_components.interfaces.WebFormComponent;

import java.util.List;

/**
 * Created by mariusmerkevicius on 9/7/15.
 * An interface that defines the information about the form that must be filled
 * before information pulling
 */
public interface WPageFilterable {
    /**
     * Returns filter components that should be filled before loading
     */
    List<WebFormComponent> filterComponents();

}
