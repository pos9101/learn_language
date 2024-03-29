package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 16204
 * @link https://www.acmicpc.net/problem/16204
 */
public class DrawCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int doubleO = M < K ? M : K;
        int doubleX = N - M < N - K ? N - M : N - K;
        System.out.println(doubleO + doubleX);
        br.close();
    }
}
