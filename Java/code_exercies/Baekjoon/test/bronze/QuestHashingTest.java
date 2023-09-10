package bronze;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class QuestHashingTest {

    @Test
    void powTest() {
        BigInteger[] memory = new BigInteger[50];
        for (int i = 0; i < 50; i++) {
            memory[i] = new BigInteger("0");
        }
        System.out.println(QuestHashing.pow(memory, 31, 0));
        System.out.println(QuestHashing.pow(memory, 31, 1));
        System.out.println(QuestHashing.pow(memory, 31, 2));
        System.out.println(QuestHashing.pow(memory, 31, 3));
        System.out.println(QuestHashing.pow(memory, 31, 4));
        System.out.println(QuestHashing.pow(memory, 31, 5));
        System.out.println(QuestHashing.pow(memory, 31, 6));
        System.out.println(QuestHashing.pow(memory, 31, 7));
        System.out.println(QuestHashing.pow(memory, 31, 8));
        System.out.println(QuestHashing.pow(memory, 31, 9));
        System.out.println(QuestHashing.pow(memory, 31, 10));
        System.out.println(QuestHashing.pow(memory, 31, 11));
        System.out.println(QuestHashing.pow(memory, 31, 12));
        System.out.println(QuestHashing.pow(memory, 31, 13));
        System.out.println(QuestHashing.pow(memory, 31, 14));
        System.out.println(QuestHashing.pow(memory, 31, 15));
        System.out.println(QuestHashing.pow(memory, 31, 16));
        System.out.println(QuestHashing.pow(memory, 31, 17));
        System.out.println(QuestHashing.pow(memory, 31, 18));
        System.out.println(QuestHashing.pow(memory, 31, 19));
        System.out.println(QuestHashing.pow(memory, 31, 20));
        System.out.println(QuestHashing.pow(memory, 31, 21));
        System.out.println(QuestHashing.pow(memory, 31, 22));
        System.out.println(QuestHashing.pow(memory, 31, 23));
        System.out.println(QuestHashing.pow(memory, 31, 24));
        System.out.println(QuestHashing.pow(memory, 31, 25));
        System.out.println(QuestHashing.pow(memory, 31, 26));
        System.out.println(QuestHashing.pow(memory, 31, 27));
        System.out.println(QuestHashing.pow(memory, 31, 28));
        System.out.println(QuestHashing.pow(memory, 31, 29));
        System.out.println(QuestHashing.pow(memory, 31, 30));
        System.out.println(QuestHashing.pow(memory, 31, 31));
        System.out.println(QuestHashing.pow(memory, 31, 32));
        System.out.println(QuestHashing.pow(memory, 31, 33));
        System.out.println(QuestHashing.pow(memory, 31, 34));
        System.out.println(QuestHashing.pow(memory, 31, 35));
        System.out.println(QuestHashing.pow(memory, 31, 36));
        System.out.println(QuestHashing.pow(memory, 31, 37));
        System.out.println(QuestHashing.pow(memory, 31, 38));
        System.out.println(QuestHashing.pow(memory, 31, 39));
        System.out.println(QuestHashing.pow(memory, 31, 40));
        System.out.println(QuestHashing.pow(memory, 31, 41));
        System.out.println(QuestHashing.pow(memory, 31, 42));
        System.out.println(QuestHashing.pow(memory, 31, 43));
        System.out.println(QuestHashing.pow(memory, 31, 44));
        System.out.println(QuestHashing.pow(memory, 31, 45));
        System.out.println(QuestHashing.pow(memory, 31, 46));
        System.out.println(QuestHashing.pow(memory, 31, 47));
        System.out.println(QuestHashing.pow(memory, 31, 48));
        System.out.println(QuestHashing.pow(memory, 31, 49));
    }

}