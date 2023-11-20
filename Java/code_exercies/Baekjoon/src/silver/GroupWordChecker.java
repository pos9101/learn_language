package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Baekjoon 1316
 * @link https://www.acmicpc.net/problem/1316
 */
public class GroupWordChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGroupWord(word)) {
                ++count;
            }
        }
        System.out.println(count);
        br.close();
    }

    private static boolean isGroupWord(String word) {
        //key: Character, value: lastIndex
        Map<Character, Integer> checker = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c  = word.charAt(i);
            if (!checker.containsKey(c)) {
                checker.put(c, i);
            } else {
                Integer index = checker.get(c);
                if (index == i - 1) {
                    checker.put(c, i);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
