package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 17173
 * @link https://www.acmicpc.net/problem/17173
 */
public class MultipleSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] kArray = new int[M];
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            kArray[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int k : kArray) {
                if(i % k == 0) {
                    sum += i;
                    break;
                }
            }
        }
        System.out.println(sum);
        br.close();
    }
}
