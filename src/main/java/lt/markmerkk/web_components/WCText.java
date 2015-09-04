package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebComponentBase;
import lt.markmerkk.web_components.interfaces.WebComponentText;

/**
 * Created by mariusmerkevicius on 9/4/15.
 */
public final class WCText implements WebComponentBase, WebComponentText {

    String path;
    String text;

    public WCText(String path, String value) {
        this.path = path;
        this.text = value;
    }

    @Override
    public String path() {
        return path;
    }

    @Override
    public String text() {
        return text;
    }
}
