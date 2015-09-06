package lt.markmerkk.interfaces.page;

/**
 * Created by mariusmerkevicius on 9/7/15.
 * An interface that defines the data that is required to inspect information
 * about the data that must be pulled.
 */
public interface WPageResultSearchable {
    /**
     * Defines the xpath to the table that holds all the information
     * @return
     */
    String tableXpath();

    /**
     * Defines the xpath for one item from the table
     * @return
     */
    String itemXpath();
}
