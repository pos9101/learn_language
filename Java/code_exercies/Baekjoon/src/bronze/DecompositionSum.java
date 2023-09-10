package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 2231
 * @link https://www.acmicpc.net/problem/2231
 */
public class DecompositionSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[] decompositionSums = new int[N];
        //999,999 -> 999999 + (9 + 9 + 9 + 9 + 9 + 9) (54)
        int start = (N - 54 > 1) ?  N -54 : 1;
        boolean findResult = false;
        for (int result = start; result < N; result++) {
            decompositionSums[result] = calculateDecompositionSum(result);
            if(decompositionSums[result] == N) {
                System.out.println(result);
                findResult = true;
                break;
            }
        }
        if(!findResult) {
            System.out.println(0);
        }

        br.close();
    }

    private static int calculateDecompositionSum(int num) {
        int temp = num;
        int sum = num;

        while(temp / 10 != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        sum += temp;
        return sum;
    }
}
