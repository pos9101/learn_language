package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 2292
 * @link https://www.acmicpc.net/problem/2292
 */
public class Honeycomb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 1 + 6 + 12 + 18 + 24
        int combNum = 1;
        int count = 1;
        while(combNum < n) {
            combNum += count * 6;
            count++;
        }

        System.out.println(count);

        br.close();
    }
}
