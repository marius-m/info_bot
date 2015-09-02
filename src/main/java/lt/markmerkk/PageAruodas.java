package lt.markmerkk;

import lt.markmerkk.interfaces.WPage;

/**
 * Created by mariusmerkevicius on 9/2/15.
 * Concrete "aruodas" page object
 */
public class PageAruodas implements WPage {
    @Override
    public String pageUrl() {
        return "http://aruodas.lt";
    }
}
