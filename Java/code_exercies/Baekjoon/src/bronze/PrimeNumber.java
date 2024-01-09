package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Baekjoon 2581
 * @link https://www.acmicpc.net/problem/2581
 */
public class PrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int M = Integer.parseInt(br.readLine());
        final int N = Integer.parseInt(br.readLine());
        boolean[] isNotPrimeNum = new boolean[N + 1];
        isNotPrimeNum[0] = true;
        isNotPrimeNum[1] = true;
        for (int i = 2; i <= Math.sqrt(N) ; i++) {
            for (int j = i * i; j <= N; j += i) {
                isNotPrimeNum[j] = true;
            }
        }
        int sum = IntStream.rangeClosed(M, N).filter(x -> !isNotPrimeNum[x]).sum();
        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            for (int i = M; i <= N; i++) {
                if(!isNotPrimeNum[i]) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
