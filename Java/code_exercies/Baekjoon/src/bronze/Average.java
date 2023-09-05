package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Baekjoon 1546
 * @link https://www.acmicpc.net/problem/1546
 */
public class Average {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfTestcase = Integer.parseInt(br.readLine());
        int[] scores = new int[numOfTestcase];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < numOfTestcase; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        OptionalInt max = Arrays.stream(scores).max();
        System.out.println(Arrays.stream(scores).
                mapToDouble(a -> a * 100 / (double)max.getAsInt())
                .average().getAsDouble());

        br.close();
    }
}
