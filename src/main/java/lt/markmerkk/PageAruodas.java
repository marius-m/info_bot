package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.WCButton;
import lt.markmerkk.web_components.WCCheckBox;
import lt.markmerkk.web_components.WCText;
import lt.markmerkk.web_components.interfaces.WebComponentBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mariusmerkevicius on 9/2/15.
 * Concrete "aruodas" page object
 */
public class PageAruodas implements WPage {
    @Override
    public String url() {
        return "http://aruodas.lt";
    }

    @Override
    public List<WebComponentBase> filterComponents() {
        return new ArrayList<WebComponentBase>() {{
            add(new WCCheckBox("room_number_from", "//select[@name='FRoomNumMin']", "2"));
            add(new WCCheckBox("room_number_to", "//select[@name='FRoomNumMax']", "3"));
            add(new WCText("max_price", "//input[@name='FPriceMax']", "100000"));
            add(new WCCheckBox("region", "//select[@name='FRegion']", "Vilnius"));
            add(new WCCheckBox("district", "//select[@name='FDistrict']", "Vilniaus m."));
            add(new WCButton("filter_button", "//input[@type='submit']"));
        }};
    }
}
