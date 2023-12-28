package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 5522
 * @link https://www.acmicpc.net/problem/5522
 */
public class CardGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.lines().mapToInt(s -> Integer.parseInt(s)).sum());
        br.close();
    }
}
