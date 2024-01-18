package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 27323
 * @link https://www.acmicpc.net/problem/27323
 */
public class Square {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int A = Integer.parseInt(br.readLine());
        final int B = Integer.parseInt(br.readLine());
        System.out.println(A * B);
    }
}
