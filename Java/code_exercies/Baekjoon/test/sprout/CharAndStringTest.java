package sprout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharAndStringTest {

    @Test
    void findSpellInStringTest() {
        Assertions.assertEquals('r', CharAndString.findSpellInString("Sprout", 3));
        Assertions.assertEquals('p', CharAndString.findSpellInString("shiftpsh", 6));
        Assertions.assertEquals('k', CharAndString.findSpellInString("Baekjoon", 4));
    }

}