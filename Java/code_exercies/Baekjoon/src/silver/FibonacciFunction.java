package silver;

import java.io.*;

/**
 * Baekjoon 1003
 * @link https://www.acmicpc.net/problem/1003
 */
public class FibonacciFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(solveFibonacci(n) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static String solveFibonacci(final int n) {
        int[] zeroCountMemory = new int[n + 2];
        int[] oneCountMemory = new int[n + 2];
        zeroCountMemory[0] = 1;
        zeroCountMemory[1] = 0;
        oneCountMemory[0] = 0;
        oneCountMemory[1] = 1;
        int cntZero = countZeroFibonacci(zeroCountMemory, n);
        int cntOne = countOneFibonacci(oneCountMemory, n);

        return zeroCountMemory[n] + " " + oneCountMemory[n];
    }

    private static int countZeroFibonacci(int[] zeroCountMemory, int n) {
        if(zeroCountMemory[n] != 0) {
            return zeroCountMemory[n];
        }
        if(n == 0) {
            return 1;
        }else if(n == 1) {
            return 0;
        }
        zeroCountMemory[n] = countZeroFibonacci(zeroCountMemory, n - 1) + countZeroFibonacci(zeroCountMemory, n - 2);
        return zeroCountMemory[n];
    }

    private static int countOneFibonacci(int[] oneCountMemory, int n) {
        if(oneCountMemory[n] != 0) {
            return oneCountMemory[n];
        }
        if(n == 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }
        oneCountMemory[n] = countOneFibonacci(oneCountMemory, n - 1) + countOneFibonacci(oneCountMemory, n - 2);
        return oneCountMemory[n];
    }


}
