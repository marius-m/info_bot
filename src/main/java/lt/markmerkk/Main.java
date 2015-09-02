package lt.markmerkk;

import lt.markmerkk.components.DaggerSimpleWebRunnerComponent;

public class Main {

    public static void main(String[] args) {
        DaggerSimpleWebRunnerComponent.create().maker().run(new PageAruodas(), null);
    }
}
