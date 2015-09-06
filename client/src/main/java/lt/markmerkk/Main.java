package lt.markmerkk;

import lt.markmerkk.components.DaggerWebRunnerComponent;
import lt.markmerkk.components.WebRunnerComponent;
import lt.markmerkk.modules.WebRunnerModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    // Disabling log output from selenium
    static{
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Starting app");

        WebRunnerComponent component = DaggerWebRunnerComponent.builder()
                .webRunnerModule(new WebRunnerModule(new PageAruodas()))
                .build();
        component.runner().run();

        logger.info("Ending");
    }
}
