package lt.markmerkk.web_components;

import org.junit.Test;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCTextInitTest {
    @Test(expected = IllegalArgumentException.class)
    public void testNullValue() throws Exception {
        new WCText("asdf", "//asdf", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPath() throws Exception {
        new WCText("asdf", null, "asdf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() throws Exception {
        new WCText(null, "//asdf", "asdf");
    }

    @Test
    public void testValid() throws Exception {
        new WCText("asdf", "//asdf", "asdf");
    }

}