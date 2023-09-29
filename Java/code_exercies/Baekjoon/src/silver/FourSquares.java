package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 17626
 * @link https://www.acmicpc.net/problem/17626
 */
public class FourSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        System.out.println(solveAnswer(N));
        br.close();
    }

    private static int solveAnswer(int n) {
        int[] memory = new int[n + 1];
        memory[1] = 1;
        for (int num = 2; num <= n; num++) {
            int min = memory[num - 1] + 1; //
            for (int j = 2; (j * j) <= num; j++) {
                int val = 1 + memory[num - j * j]; //2, 4, 9, 16, .... -> 1
                if (val < min) {
                    min = val;
                }
            }
            memory[num] = min;
        }
        return memory[n];
    }
}
