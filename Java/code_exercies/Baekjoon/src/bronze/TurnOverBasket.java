package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 10811
 * @link https://www.acmicpc.net/problem/10811
 */
public class TurnOverBasket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringJoiner sj = new StringJoiner(" ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        //not use baskets[0]
        int[] baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i  = Integer.parseInt(st.nextToken());
            int j  = Integer.parseInt(st.nextToken());
            int temp;
            for (int s = 0; s <= (j - i) / 2; s++) {
                temp = baskets[i + s];
                baskets[i + s] = baskets[j - s];
                baskets[j - s] = temp;
            }
        }
        for (int i = 1; i <= N; i++) {
            sj.add(String.valueOf(baskets[i]));
        }
        System.out.println(sj.toString());
        br.close();
    }
}
