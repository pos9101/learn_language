package gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 13172
 * @link https://www.acmicpc.net/problem/13172
 */
public class Sigma {
    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int M = Integer.parseInt(br.readLine());
        long answer = 0;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int ni = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int gcd = gcd(ni, si);
            final int N = ni / gcd;
            final int S = si / gcd;
            if (S % N == 0) {
                answer += N;
            } else {
                answer += S * modularInverse(N);
            }
            answer %= MOD;
        }
        bw.write(String.valueOf(answer) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static long modularInverse(long b) {
        int exponent = MOD - 2;
        long result = 1;
        while (exponent > 0) {
            if(exponent % 2 == 1) result = result * b % MOD;
            b = b * b % MOD;
            exponent /= 2;
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
