package sprout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountNumTest {

    @Test
    void findNumCountTest() {
        Assertions.assertEquals(3, CountNum.findNumCount(new int[]{1, 4, 1, 2, 4, 2, 4, 2, 3, 4, 4}, 2));
        Assertions.assertEquals(0, CountNum.findNumCount(new int[]{1, 4, 1, 2, 4, 2, 4, 2, 3, 4, 4}, 5));
    }

}