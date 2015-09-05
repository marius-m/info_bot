package lt.markmerkk;

import lt.markmerkk.components.DaggerSimpleWebRunnerComponent;
import lt.markmerkk.modules.SimpleWebRunnerModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    // Disabling log output from selenium
    static{
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "warn");
    }

    public static void main(String[] args) { }
}
