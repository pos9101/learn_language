package sprout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CalculateGradeTest {

    @Test
    void calGradeTest() throws IOException {
        Assertions.assertEquals(4.3f, CalculateGrade.calGrade('A', '+'));
        Assertions.assertEquals(4.0f, CalculateGrade.calGrade('A', '0'));
        Assertions.assertEquals(3.7f, CalculateGrade.calGrade('A', '-'));
        Assertions.assertEquals(3.3f, CalculateGrade.calGrade('B', '+'));
        Assertions.assertEquals(3.0f, CalculateGrade.calGrade('B', '0'));
        Assertions.assertEquals(2.7f, CalculateGrade.calGrade('B', '-'));
        Assertions.assertEquals(2.3f, CalculateGrade.calGrade('C', '+'));
        Assertions.assertEquals(2.0f, CalculateGrade.calGrade('C', '0'));
        Assertions.assertEquals(1.7f, CalculateGrade.calGrade('C', '-'));
        Assertions.assertEquals(1.3f, CalculateGrade.calGrade('D', '+'));
        Assertions.assertEquals(1.0f, CalculateGrade.calGrade('D', '0'));
        Assertions.assertEquals(0.7f, CalculateGrade.calGrade('D', '-'));
        Assertions.assertEquals(0.0f, CalculateGrade.calGrade('F', '\0'));
    }
}