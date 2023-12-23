package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Baekjoon 30224
 * @link https://www.acmicpc.net/problem/30224
 */
public class Lucky7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        boolean contains7 = IntStream.range(0, line.length())
                .filter(idx -> line.charAt(idx) == '7')
                .findAny().isPresent();
        boolean divisible = Integer.parseInt(line) % 7 == 0;
        System.out.println(lucky(contains7, divisible));
        br.close();
    }

    private static int lucky(boolean contains7, boolean divisible) {
        if(!contains7) {
            if(!divisible) return 0;
            return 1;
        }
        if(!divisible) return 2;
        return 3;
    }
}
