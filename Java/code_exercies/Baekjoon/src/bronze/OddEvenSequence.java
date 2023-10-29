package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 25629
 * @link https://www.acmicpc.net/problem/25629
 */
public class OddEvenSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int oddNum;
        if(N % 2 == 0) {
            oddNum = N / 2;
        } else {
            oddNum = N / 2 + 1;
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n % 2 == 1) ++count;
        }
        if(oddNum == count) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
        br.close();
    }
}
