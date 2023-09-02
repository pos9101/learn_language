package bronze;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Baekjoon 10809
 * @link https://www.acmicpc.net/problem/10809
 */
public class FindAlphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        LinkedHashMap<Character, Integer> alphabetPositionMap = new LinkedHashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetPositionMap.put(c, -1);
        }

        int length = word.length();

        Iterator<Character> iter = alphabetPositionMap.keySet().iterator();
        for (Character spell : alphabetPositionMap.keySet()) {
            for (int i = 0; i < length; i++) {
                if (spell == word.charAt(i)) {
                    alphabetPositionMap.put(spell, i);
                    break;
                }
            }
        }

        for (Integer value : alphabetPositionMap.values()) {
            bw.write(value + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
