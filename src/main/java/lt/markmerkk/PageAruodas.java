package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;
import lt.markmerkk.web_components.WCCheckBox;
import lt.markmerkk.web_components.WCText;
import lt.markmerkk.web_components.interfaces.WebComponentBase;

import java.util.HashMap;

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
    public HashMap<String, WebComponentBase> filterComponents() {
        return new HashMap<String, WebComponentBase>() {{
            //put("size_from", new WCText("//input[@name='FAreaOverAllMin']", "100"));
            put("room_number_from", new WCCheckBox("//select[@name='FRoomNumMin']", "2"));
            put("room_number_to", new WCCheckBox("//select[@name='FRoomNumMax']", "3"));
            put("max_price", new WCText("//input[@name='FPriceMax']", "100000"));
            put("region", new WCCheckBox("//select[@name='FRegion']", "Vilnius"));
            put("district", new WCCheckBox("//select[@name='FDistrict']", "Vilniaus m."));
        }};
    }
}
