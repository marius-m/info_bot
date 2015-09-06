package lt.markmerkk.web_components;

import lt.markmerkk.web_components.interfaces.WebFormSupportComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mariusmerkevicius on 9/7/15.
 */
public class WCSleep implements WebFormSupportComponent {

    public static final String NAME = "Zzzz...";
    private static final int DEFAULT_DELAY = 5;
    private final Logger logger;

    int delay = DEFAULT_DELAY;

    public WCSleep(int delayInSeconds) {
        this.delay = delayInSeconds;
        logger = LoggerFactory.getLogger(WCSleep.class);
    }

    @Override
    public void exec() {
        logger.info("Sleeping for "+delay+" seconds...");
        try {
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) { }
    }

    @Override
    public String name() {
        return NAME;
    }
}
