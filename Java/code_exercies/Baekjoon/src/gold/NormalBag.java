package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 12865
 * @link https://www.acmicpc.net/problem/12865
 */
public class NormalBag {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int[][] memory = new int[N][K + 1];
        int[] weights = new int[K + 1];
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            final int W = Integer.parseInt(st.nextToken());
            final int V = Integer.parseInt(st.nextToken());
            weights[i] = W;
            values[i] = V;
        }
        for (int w = 0; w <= K; w++) if (w >= weights[0]) memory[0][w] = values[0];
        for (int i = 1; i < N; i++) {
            for (int w = 0; w <= K; w++) {
                if(w < weights[i]) {
                    memory[i][w] = memory[i - 1][w];
                } else {
                    memory[i][w] = Math.max(memory[i - 1][w], memory[i - 1][w - weights[i]] + values[i]);
                }
            }
        }
        System.out.println(memory[N - 1][K]);
        br.close();
    }
}
