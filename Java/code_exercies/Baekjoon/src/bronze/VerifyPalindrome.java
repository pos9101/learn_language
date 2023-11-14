package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 10988
 * @link https://www.acmicpc.net/problem/10988
 */
public class VerifyPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(isPalindrome(line));
        br.close();
    }

    private static int isPalindrome(String line) {
        for (int i = 0; i <= (line.length() - 1) / 2; i++) {
            if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }
}
