package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1806
 * @link https://www.acmicpc.net/problem/1806
 */
public class ParticalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int e = 0;
        int sum = 0;
        int min = 100000;
        for (int s = 0; s < N; s++) {

            //loop out e is nextNum
            while (e < N && sum < S) {
                sum += arr[e];
                ++e;
            }
            //arr[s] ~ arr[e]
            if (sum >= S && e - s < min) {
                min = e - s;
            }
            sum -= arr[s];
        }
        System.out.println(min != 100000 ? min : 0);
        br.close();
    }
}
