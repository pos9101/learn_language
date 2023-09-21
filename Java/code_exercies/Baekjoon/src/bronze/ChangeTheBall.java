package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 10813
 * @link https://www.acmicpc.net/problem/10813
 */
public class ChangeTheBall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringJoiner sj = new StringJoiner(" ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        //not used baskets[0]
        int[] baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }
        int temp;
        for (int times = 0; times < M; times++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            temp = baskets[i];
            baskets[i] = baskets[j];
            baskets[j] = temp;
        }
        Arrays.stream(baskets).filter(value -> value != 0).forEach(x -> sj.add(String.valueOf(x)));
        System.out.println(sj.toString());
        br.close();
    }
}
