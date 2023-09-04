package bronze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindingPrimeNumberTest {

    @Test
    void isPrimeNumberTest() {
        Assertions.assertEquals(false, FindingPrimeNumber.isPrimeNumber(1));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(2));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(3));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(5));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(7));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(11));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(13));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(17));
        Assertions.assertEquals(false, FindingPrimeNumber.isPrimeNumber(18));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(19));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(23));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(29));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(31));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(37));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(41));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(43));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(47));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(53));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(59));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(61));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(67));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(71));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(73));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(79));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(83));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(89));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(97));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(101));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(103));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(107));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(109));
        Assertions.assertEquals(true, FindingPrimeNumber.isPrimeNumber(113));

    }
}