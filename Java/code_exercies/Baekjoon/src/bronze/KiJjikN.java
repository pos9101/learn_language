package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Baekjoon 2742
 * @link https://www.acmicpc.net/problem/2742
 */
public class KiJjikN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        IntStream.rangeClosed(1, N).map(i -> N - i + 1).boxed().forEach(System.out::println);
        br.close();
    }
}
