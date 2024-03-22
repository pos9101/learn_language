package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 28281
 * @link https://www.acmicpc.net/problem/28281
 */
public class Present {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            int twoX = X * (prices[i] + prices[i + 1]);
            if(twoX < answer) answer = twoX;
        }
        System.out.println(answer);
        br.close();
    }
}
