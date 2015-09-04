package lt.markmerkk.web_components;

import org.junit.Test;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCCheckBoxInitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() throws Exception {
        new WCCheckBox(null, "//asdf", "asdf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullValue() throws Exception {
        new WCCheckBox("asdf", "//asdf", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPath() throws Exception {
        new WCCheckBox("asdf", null, "asdf");
    }

    @Test
    public void testValid() throws Exception {
        new WCCheckBox("asdf", "//asdf", "asdf");
    }
}