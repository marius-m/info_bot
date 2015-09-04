package lt.markmerkk;

import lt.markmerkk.components.DaggerSimpleWebRunnerComponent;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.modules.SimpleWebRunnerModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) {
//        DaggerSimpleWebRunnerComponent.builder()
//                .simpleWebRunnerModule(new SimpleWebRunnerModule())
//                .build()
//                .maker()
//                .run();
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello World");

    }
}
