package silver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeliverSugarTest {

    @Test
    void findMinNumberOfBagTest() {
        Assertions.assertEquals(4, DeliverSugar.findMinNumberOfBag(18));
        Assertions.assertEquals(-1, DeliverSugar.findMinNumberOfBag(4));
        Assertions.assertEquals(2, DeliverSugar.findMinNumberOfBag(6));
        Assertions.assertEquals(3, DeliverSugar.findMinNumberOfBag(9));
        Assertions.assertEquals(3, DeliverSugar.findMinNumberOfBag(11));
    }
}