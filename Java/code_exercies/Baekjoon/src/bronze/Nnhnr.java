package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 24296
 * @link https://www.acmicpc.net/problem/24296
 */
public class Nnhnr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n % 2 != 0) {
            n = (n + 1) / 2;
        }
        System.out.println(n);
        br.close();
    }
}
