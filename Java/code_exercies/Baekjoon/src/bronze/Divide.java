package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 1075
 * @link https://www.acmicpc.net/problem/1075
 */
public class Divide {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N > 100) N = N / 100 * 100;
        final int F = Integer.parseInt(br.readLine());
        int remainder = (N % F) == 0 ? 0 : F - (N % F);
        System.out.println(String.format("%02d", remainder));
        br.close();
    }
}
