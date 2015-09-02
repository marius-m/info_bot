package lt.markmerkk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {
        WebDriver wb = new FirefoxDriver();
        wb.get("http://www.aruodas.lt");
        PageInspector inspector = new SimplePageInspector(wb);
        WPage page = new PageAroudas();
        inspector.inspect(page);
        wb.quit();
    }
}
