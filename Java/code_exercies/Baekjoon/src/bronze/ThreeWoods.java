package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Baekjoon 14215
 * @link https://www.acmicpc.net/problem/14215
 */
public class ThreeWoods {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lines = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(lines).max().orElseThrow();
        int remainValues = Arrays.stream(lines).sum() - max;
        if (max >= remainValues) {
            max = remainValues - 1;
        }
        System.out.println(max + remainValues);

        br.close();
    }
}
