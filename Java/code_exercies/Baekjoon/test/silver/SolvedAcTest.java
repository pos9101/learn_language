package silver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolvedAcTest {

    @Test
    void takeExceptLowerValueTest() {
        int[] levelArray =
                {0, 2, 3, 5, 5, 5,
                    5, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0};

        int[] levelArray2 =
                {0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0};

        int[] levelArray3 =
                {0, 1, 1, 1, 1, 1,
                    2, 0, 1, 1, 1,
                    0, 1, 0, 1, 3,
                    2, 0, 0, 1, 1,
                    2, 1, 1, 1, 1,
                    1, 1, 1, 1, 1};

        int[] levelArray4 =
                {0, 1, 0, 0, 0, 2,
                    0, 1, 1, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0};

        int exceptValue = SolvedAc.takeExceptLowerValue(levelArray, 25, 4);
        int exceptValue2 = SolvedAc.takeExceptLowerValue(levelArray2, 0, 0);
        int exceptValue3 = SolvedAc.takeExceptLowerValue(levelArray3, 25, 4);
        int exceptValue4 = SolvedAc.takeExceptLowerValue(levelArray4, 5, 1);

        Assertions.assertEquals(6, exceptValue);
        Assertions.assertEquals(0, exceptValue2);
        Assertions.assertEquals(10, exceptValue3);
        Assertions.assertEquals(1, exceptValue4);
    }

    @Test
    void takeExceptUpperValueTest() {
        int[] levelArray =
                {0, 2, 3, 5, 5, 5,
                    5, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0};

        int[] levelArray2 =
                {0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0};

        int[] levelArray3 =
                {0, 1, 1, 1, 1, 1,
                    2, 0, 1, 1, 1,
                    0, 1, 0, 1, 3,
                    2, 0, 0, 1, 1,
                    2, 1, 1, 1, 1,
                    1, 1, 1, 1, 1};

        int[] levelArray4 =
                {0, 1, 0, 0, 0, 2,
                    0, 1, 1, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0};

        int exceptValue = SolvedAc.takeExceptUpperValue(levelArray, 25, 4);
        int exceptValue2 = SolvedAc.takeExceptUpperValue(levelArray2, 0, 0);
        int exceptValue3 = SolvedAc.takeExceptUpperValue(levelArray3, 25, 4);
        int exceptValue4 = SolvedAc.takeExceptUpperValue(levelArray4, 5, 1);

        Assertions.assertEquals(24, exceptValue);
        Assertions.assertEquals(0, exceptValue2);
        Assertions.assertEquals(114, exceptValue3);
        Assertions.assertEquals(8, exceptValue4);
    }

}