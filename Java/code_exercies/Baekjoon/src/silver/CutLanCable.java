package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 1654
 * @link https://www.acmicpc.net/problem/1654
 */
public class CutLanCable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int K = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        long[] lanCables = new long[K];
        for (int i = 0; i < K; i++) {
            lanCables[i] = Long.parseLong(br.readLine());
        }
        System.out.println(findMaxLengthOfLanCable(Arrays.stream(lanCables).sorted().toArray(), N,
                1, Arrays.stream(lanCables).max().getAsLong()));

        br.close();
    }

    private static long findMaxLengthOfLanCable(long[] lanCables, final int N, long min, long max) {
        if(min > max)
            return max;
        long mid = (min + max) / 2;
        long madeNum = Arrays.stream(lanCables).reduce(0, (total, value) -> total + (value / mid));
        if(madeNum >= N) {
            return findMaxLengthOfLanCable(lanCables, N, mid + 1, max);
        } else {
            return findMaxLengthOfLanCable(lanCables, N, min, mid - 1);
        }
    }
}
