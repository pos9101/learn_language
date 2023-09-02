package sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 27866
 * @link https://www.acmicpc.net/problem/27866
 */
public class CharAndString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int num = Integer.parseInt(br.readLine());

        System.out.println(findSpellInString(word, num));

        br.close();
    }

    public static char findSpellInString(String word, int num) {
        return word.charAt(num - 1);
    }
}
