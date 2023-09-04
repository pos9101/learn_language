package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1978
 * @link https://www.acmicpc.net/problem/1978
 */
public class FindingPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrimeNumber(num)) {
                sum++;
            }
        }

        System.out.println(sum);
        br.close();
    }

    public static boolean isPrimeNumber(int n) {
        if(n <= 1) {
            return false;
        }
        for (int i = 2; i <= n - 1; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
