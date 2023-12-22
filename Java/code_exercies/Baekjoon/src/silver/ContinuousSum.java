package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 1912
 * @link https://www.acmicpc.net/problem/1912
 */
public class ContinuousSum {
    static final int MIN = -100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] array = new int[n];
        int[] memory = new int[n];
        Arrays.fill(memory, MIN);
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dpContinuousSumWithCurrent(memory, array, i);
        }
        System.out.println(Arrays.stream(memory).max().orElseThrow());
        br.close();
    }

    private static int dpContinuousSumWithCurrent(int[] memory, int[] array, int i) {
        if (memory[i] != MIN) {
            return memory[i];
        }
        if (i == 0) {
            memory[i] = array[i];
            return memory[i];
        }
        memory[i] = Math.max(dpContinuousSumWithCurrent(memory, array, i - 1) + array[i], array[i]);
        return memory[i];
    }
}
