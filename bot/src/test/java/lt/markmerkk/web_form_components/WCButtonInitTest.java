package lt.markmerkk.web_form_components;

import org.junit.Test;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCButtonInitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullName() throws Exception {
        new WCButton(null, "//asdf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullXpath() throws Exception {
        new WCButton("aasdf", null);
    }

    @Test
    public void testValid() throws Exception {
        new WCButton("asdf", "//asdf");
    }
}