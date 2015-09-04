package lt.markmerkk.web_components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mariusmerkevicius on 9/5/15.
 */
public class WCTextInitTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullPath() throws Exception {
        new WCText(null, "asdf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullValue() throws Exception {
        new WCText("//someXpath", null);
    }

    @Test
    public void testValidCreation() throws Exception {
        assertNotNull(new WCText("//someXpath", "asdf"));
    }
}