package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebComponentBase;

/**
 * Created by mariusmerkevicius on 9/5/15.
 * A base abstract class that represents component data that is
 * used for filling in user input.
 */
public abstract class WCBaseInput implements WebComponentBase {
    final String name;
    final String path;
    final String value;

    public WCBaseInput(String name, String path, String value) {
        if (path == null)
            throw new IllegalArgumentException("Xpath must be defined!");
        if (name == null)
            throw new IllegalArgumentException("Name must be defined!");
        this.name = name;
        this.path = path;
        this.value = value;
    }

    @Override
    public String xpath() {
        return path;
    }

    @Override
    public String name() {
        return name;
    }
}
