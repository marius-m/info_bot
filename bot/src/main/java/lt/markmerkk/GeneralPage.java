package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.interfaces.WebInputComponent;

import java.util.List;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class GeneralPage implements WPage {
    @Override
    public String url() {
        return null;
    }

    @Override
    public List<WebInputComponent> filterComponents() {
        return null;
    }
}
