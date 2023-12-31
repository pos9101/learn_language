package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * Baekjoon 1427
 * @link https://www.acmicpc.net/problem/1427
 */
public class SortInside {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        IntStream.range(0, n.length())
                .map(i -> Character.getNumericValue(n.charAt(i))).boxed()
                .sorted(Collections.reverseOrder())
                .forEach(System.out::print);
        br.close();
    }
}
