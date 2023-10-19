package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 11053
 * @link https://www.acmicpc.net/problem/11053
 */
public class LongestIncresingSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] maxSequence = new int[N];
        Arrays.fill(maxSequence, 1);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(maxSequence[j] >= maxSequence[i] && numbers[i] > numbers[j]) {
                    maxSequence[i] = maxSequence[j] + 1;
                }
            }
        }
        System.out.println(Arrays.stream(maxSequence).max().getAsInt());
        br.close();
    }
}
