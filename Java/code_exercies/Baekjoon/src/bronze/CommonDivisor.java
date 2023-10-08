package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1037
 * @link https://www.acmicpc.net/problem/1037
 */
public class CommonDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = 1000000;
        int max = 2;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num > max) max = num;
            if(num < min) min = num;
        }
        System.out.println(max * min);
        br.close();
    }
}
