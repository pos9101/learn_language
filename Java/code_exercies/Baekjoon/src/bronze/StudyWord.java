package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Baekjoon 1157
 * @link https://www.acmicpc.net/problem/1157
 */
public class StudyWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> charMap = new HashMap<>();

        String line = br.readLine().toUpperCase();

        int length = line.length();
        for (int i = 0; i < length; i++) {
            char c = line.charAt(i);
            if(charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }
        char maxSpell = 0;
        int max = 0;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if(entry.getValue() > max) {
                maxSpell = entry.getKey();
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                maxSpell = '?';
            }
        }

        System.out.println(maxSpell);

        br.close();
    }
}
