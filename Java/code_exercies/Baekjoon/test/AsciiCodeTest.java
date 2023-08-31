import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsciiCodeTest {

    @Test
    void changeCharToIntTest() {
        Assertions.assertEquals(65, AsciiCode.changeCharToInt('A'));
        Assertions.assertEquals(67, AsciiCode.changeCharToInt('C'));
        Assertions.assertEquals(48, AsciiCode.changeCharToInt('0'));
        Assertions.assertEquals(57, AsciiCode.changeCharToInt('9'));
        Assertions.assertEquals(97, AsciiCode.changeCharToInt('a'));
        Assertions.assertEquals(122, AsciiCode.changeCharToInt('z'));
    }
}