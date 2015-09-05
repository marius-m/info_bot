package lt.markmerkk.web_components;

import org.junit.Test;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCCheckBoxInitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() throws Exception {
        new WCCheckBox(null, "//asdf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPath() throws Exception {
        new WCCheckBox("asdf", null);
    }

    @Test
    public void testValid() throws Exception {
        new WCCheckBox("asdf", "//asdf");
    }
}