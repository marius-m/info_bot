package lt.markmerkk;

import lt.markmerkk.components.DaggerSimpleWebRunnerComponent;
import lt.markmerkk.interfaces.PageFilter;
import lt.markmerkk.modules.SimpleWebRunnerModule;

public class Main {

    public static void main(String[] args) {
        //PageFilter filter = new FilterAruodas();
        DaggerSimpleWebRunnerComponent.builder()
                .simpleWebRunnerModule(new SimpleWebRunnerModule())
                .build()
                .maker()
                .run();
    }
}
