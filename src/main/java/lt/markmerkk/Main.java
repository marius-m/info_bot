package lt.markmerkk;

import lt.markmerkk.components.DaggerSimpleWebRunnerComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {
        DaggerSimpleWebRunnerComponent.create().maker().run();
//        wb.get("http://www.aruodas.lt");

//        PageInspector inspector = new SimplePageInspector(wb);
//        WPage page = new PageAroudas();
//        inspector.inspect(page);

//        wb.quit();
    }
}
