package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Baekjoon 2501
 * @link https://www.acmicpc.net/problem/2501
 */
public class FindCommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int[] array = Arrays.stream(IntStream.rangeClosed(1, N)
                .filter(x -> N % x == 0).limit(K).toArray()).toArray();
        System.out.println(array.length < K ? 0 : array[K - 1]);
    }
}
