package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 15894
 * @link https://www.acmicpc.net/problem/15894
 */
public class MathIsPhysical {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(4L * n);
        br.close();
    }
}
