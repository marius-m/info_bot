package lt.markmerkk.web_components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCButtonInitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullXpath() throws Exception {
        new WCButton(null);
    }

    @Test
    public void testValid() throws Exception {
        new WCButton("//asdf");
    }
}