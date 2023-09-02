package bronze;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Baekjoon 2577
 * @link https://www.acmicpc.net/problem/2577
 */
public class NumberOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());
        String multipleValue = String.valueOf(num1 * num2 * num3);

        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for(char c ='0'; c <= '9'; c++) {
            countMap.put(c, 0);
        }


        int length = multipleValue.length();
        for (int i = 0; i < length; i++) {
            char spell = multipleValue.charAt(i);
            int addedNum = countMap.get(spell) + 1;
            countMap.put(spell, addedNum);
        }

        for (Integer val : countMap.values()) {
            bw.write(val + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
