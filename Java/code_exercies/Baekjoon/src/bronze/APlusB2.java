package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 2558
 * @link https://www.acmicpc.net/problem/2558
 */
public class APlusB2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int A = Integer.parseInt(br.readLine());
        final int B = Integer.parseInt(br.readLine());
        System.out.println(A + B);
        br.close();
    }
}
