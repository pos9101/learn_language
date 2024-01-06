package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Baekjoon 2752
 * @link https://www.acmicpc.net/problem/2752
 */
public class ThreeNumSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(" ");
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .sorted().forEach(x -> sj.add(String.valueOf(x)));
        System.out.println(sj.toString());
        br.close();
    }
}
