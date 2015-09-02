package lt.markmerkk.interfaces;

/**
 * Created by mariusmerkevicius on 9/2/15.
 * An abstract runner class that handles {@link org.openqa.selenium.WebDriver} usage
 */
public interface WebRunner {
    /**
     * Runner method with provided inspector
     * @param page
     * @param inspector
     */
    void run(WPage page, PageInspector inspector);

}
