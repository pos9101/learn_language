package silver;

import java.io.*;

/**
 * Baekjoon 9461
 * @link https://www.acmicpc.net/problem/9461
 */
public class WaveSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        long[] memory = new long[101];
        memory[1] = 1;
        memory[2] = 1;
        memory[3] = 1;
        memory[4] = 2;
        memory[5] = 2;
        memory[6] = 3;
        memory[7] = 4;
        memory[8] = 5;
        memory[9] = 7;
        memory[10] = 9;

        for (int i = 0; i < T; i++) {
            bw.write(calculateWaveSequence(memory, Integer.parseInt(br.readLine())) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static long calculateWaveSequence(long[] memory, int n) {
        if (memory[n] != 0) {
            return memory[n];
        }
        memory[n] = calculateWaveSequence(memory, n - 1) + calculateWaveSequence(memory, n - 5);
        return memory[n];
    }
}
