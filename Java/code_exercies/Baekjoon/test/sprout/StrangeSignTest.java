package sprout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprout.StrangeSign;

class StrangeSignTest {
    StrangeSign strangeSign = new StrangeSign();

    @Test
    void calculateAtTest() {
        Assertions.assertEquals(1591000000L, strangeSign.calculateAt(40000, 3000).longValue());
        Assertions.assertEquals(7L, strangeSign.calculateAt(4, 3).longValue());
        Assertions.assertEquals(-7L, strangeSign.calculateAt(3, 4).longValue());
    }

}