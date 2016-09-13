package serialize.hessian;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ding.lid
 */
public class HessianTest {
    @Test
    public void test_hessian() throws Exception {
        Demo a0 = new Demo();
        assertEquals(a0, Utils.serialize(a0));
        System.out.println(a0.equals(Utils.serialize(a0)));
    }
}
