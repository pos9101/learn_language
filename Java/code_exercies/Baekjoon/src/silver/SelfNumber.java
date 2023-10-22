package silver;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * Baekjoon 4673
 * @link https://www.acmicpc.net/problem/4673
 */
public class SelfNumber {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Boolean> existMap = new HashMap<>();
        for (int i = 1; i < 10000; i++) {
            int addNumber = i;
            String s = String.valueOf(addNumber);
            for (int j = 0; j < s.length(); j++) {
                addNumber += Character.getNumericValue(s.charAt(j));
            }
            existMap.put(addNumber, true);
        }
        for (int i = 1; i <= 10000; i++) {
            if(!existMap.containsKey(i)) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
