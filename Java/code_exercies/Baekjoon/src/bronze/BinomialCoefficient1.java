package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 11050
 * @link https://www.acmicpc.net/problem/11050
 */
public class BinomialCoefficient1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int[] factorialMemory = new int[11];
        int result = factorial(factorialMemory, N) / factorial(factorialMemory, K) / factorial(factorialMemory, N - K);
        System.out.println(result);

        br.close();
    }

    private static int factorial(int[] memory, int num) {
        if (memory[num] != 0) {
            return memory[num];
        }

        if(num <= 1) { // 1!, 0!
            return memory[num] = 1;
        }
        return memory[num] = num * factorial(memory, num - 1);
    }
}
