package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Baekjoon 1644
 * @link https://www.acmicpc.net/problem/1644
 */
public class SequenceSumOfPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        boolean[] isNotPrimeNum = new boolean[N + 1];
        isNotPrimeNum[0] = true;
        isNotPrimeNum[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(isNotPrimeNum[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                isNotPrimeNum[j] = true;
            }
        }
        int[] primeNum = IntStream.rangeClosed(2, N).filter(i -> !isNotPrimeNum[i]).toArray();
        int answer = 0;
//        int s = 0;
        int e = 0;
        int sum = 0;
        for (int s = 0; s < primeNum.length; s++) {
            while(sum < N && e < primeNum.length) {
                sum += primeNum[e];
                ++e;
            }
            if (sum == N) ++answer;
            sum -= primeNum[s];
        }
        System.out.println(answer);
        br.close();
    }
}
