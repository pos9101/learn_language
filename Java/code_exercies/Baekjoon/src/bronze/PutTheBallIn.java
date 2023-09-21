package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 10810
 * @link https://www.acmicpc.net/problem/10810
 */
public class PutTheBallIn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringJoiner sj = new StringJoiner(" ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] baskets = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ballNum = Integer.parseInt(st.nextToken());
            for (int j = start - 1; j < end; j++) {
                baskets[j] = ballNum;
            }
        }
        Arrays.stream(baskets).forEach(x -> sj.add(String.valueOf(x)));
        System.out.println(sj.toString());
        br.close();
    }
}
