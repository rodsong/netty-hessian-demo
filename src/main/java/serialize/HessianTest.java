package serialize;

import org.junit.Test;
import static serialize.Utils.serialize;
import static org.junit.Assert.assertEquals;

/**
 * @author ding.lid
 */
public class HessianTest {
    @Test
    public void test_hessian() throws Exception {
        Demo a0 = new Demo();
        assertEquals(a0, serialize(a0));
        System.out.println(a0.equals(serialize(a0)));
    }
}
