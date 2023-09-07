package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2609
 * @link https://www.acmicpc.net/problem/2609
 */
public class CommonDivisorAndMultiple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int maxCommonDivisor = calculateMaxCommonDivisor(a, b);
        int minCommonMultiple = a / maxCommonDivisor * b;

        System.out.println(maxCommonDivisor);
        System.out.println(minCommonMultiple);

        br.close();
    }

    private static int calculateMaxCommonDivisor(int a, int b) {
        final int min = Math.min(a, b);
        for (int i = min; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
