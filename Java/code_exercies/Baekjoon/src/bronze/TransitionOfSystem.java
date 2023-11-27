package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2745
 * @link https://www.acmicpc.net/problem/2745
 */
public class TransitionOfSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        final int B = Integer.parseInt(st.nextToken());

        long num = 0;
        for (int i = N.length() -1; i >= 0; i--) {
            num += charToInt(N.charAt(i)) * Math.pow(B, N.length() -1 - i);
        }
        System.out.println(num);
        br.close();
    }

    private static int charToInt(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 10;
        }
        return c - '0';
    }
}
