package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 1562
 * @Link https://www.acmicpc.net/problem/1562
 */
public class StepNumber {
    static long MOD = 1000000000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        System.out.println(calculateStepNum(N));
        br.close();
    }

    private static int calculateStepNum(int n) {
        if(n < 10) return 0;
        int[][][] dp = new int[n + 1][10][1024];
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }
        //자리 수
        for (int i = 2; i <= n; i++) {
            //마지막 숫자
            for (int j = 0; j < 10; j++) {
                //bitmask
                for (int k = 0; k < 1024; k++) {
                    int bitmask = k | (1 << j);
                    int lowerStep = j != 0 ? dp[i - 1][j - 1][k] : 0;
                    int higherStep = j != 9 ? dp[i - 1][j + 1][k] : 0;
                    dp[i][j][bitmask] = (int) ((dp[i][j][bitmask] + (lowerStep + higherStep)) % MOD);

                }
            }
        }
        return takeDpResult(dp, n);
    }

    private static int takeDpResult(int[][][] dp, int n) {
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i][1023];
        }
        return (int) (answer % MOD);
    }
}
