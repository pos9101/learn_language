package bronze;

import java.io.*;

/**
 * Baekjoon 11653
 * @link https://www.acmicpc.net/problem/11653
 */
public class PrimeFactorization {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if(n % i == 0) {
                    bw.write(i + "\n");
                    n /= i;
                    break;
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
