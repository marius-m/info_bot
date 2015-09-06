package lt.markmerkk.pages;

import lt.markmerkk.interfaces.page.WPage;
import lt.markmerkk.interfaces.page.WPageFilterable;
import lt.markmerkk.interfaces.page.WPageResultSearchable;
import lt.markmerkk.web_form_components.WCButton;
import lt.markmerkk.web_form_components.WCCheckBox;
import lt.markmerkk.web_form_components.WCSleep;
import lt.markmerkk.web_form_components.WCText;
import lt.markmerkk.web_form_components.interfaces.WebFormComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariusmerkevicius on 9/2/15.
 * Concrete "aruodas" page object
 */
public class PageAruodas implements WPage, WPageFilterable, WPageResultSearchable {
    @Override
    public String url() {
        return "http://aruodas.lt";
    }

    @Override
    public List<WebFormComponent> filterComponents() {
        return new ArrayList<WebFormComponent>() {{
            add(new WCCheckBox("room_number_from", "//select[@name='FRoomNumMin']/option[@value='2']"));
            add(new WCCheckBox("room_number_to", "//select[@name='FRoomNumMax']/option[@value='3']"));
            add(new WCText("max_price", "//input[@name='FPriceMax']", "100000"));
            add(new WCCheckBox("region", "//select[@name='FRegion']/option[@value='461']"));
            add(new WCSleep(1));
            add(new WCButton("filter_button", "//form[@id='searchForm']//input[@type='submit']"));
            add(new WCSleep(5));
        }};
    }

    @Override
    public String tableXpath() {
        return null;
    }

    @Override
    public String itemXpath() {
        return null;
    }
}
