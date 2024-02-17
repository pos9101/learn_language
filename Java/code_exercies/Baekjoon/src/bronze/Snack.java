package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 10156
 * @link https://www.acmicpc.net/problem/10156
 */
public class Snack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        System.out.println(calculateReceiveMoney(K, N, M));
        br.close();
    }

    private static int calculateReceiveMoney(int K, int N, int M) {
        int needMoney = K * N;
        if(M > needMoney) return 0;
        return needMoney - M;
    }
}
