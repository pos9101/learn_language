package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 30030
 * @link https://www.acmicpc.net/problem/30030
 */
public class FindPriceOfSweetCorn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int B = Integer.parseInt(br.readLine());
        System.out.println(B / 11 * 10);
        br.close();
    }
}
