package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebComponentBase;

/**
 * Created by mariusmerkevicius on 9/5/15.
 * A base abstract class that represents component data that is
 * used for filling in user input.
 */
public abstract class WCBaseInput implements WebComponentBase {
    String path;
    String value;

    public WCBaseInput(String path, String value) {
        if (path == null)
            throw new IllegalArgumentException("Xpath must be defined!");
        this.path = path;
        if (value == null)
            throw new IllegalArgumentException("Value must be defined!");
        this.value = value;
    }

    @Override
    public String xpath() {
        return path;
    }

}
