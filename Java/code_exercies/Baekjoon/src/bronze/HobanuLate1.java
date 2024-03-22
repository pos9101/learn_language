package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 30468
 * @link https://www.acmicpc.net/problem/30468
 */
public class HobanuLate1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int STR = Integer.parseInt(st.nextToken());
        final int DEX = Integer.parseInt(st.nextToken());
        final int INT = Integer.parseInt(st.nextToken());
        final int LUK = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        int sum = STR + DEX + INT + LUK;
        if (sum > 4 * N) {
            System.out.println(0);
        } else {
            System.out.println(4 * N - sum);
        }
        br.close();
    }
}
