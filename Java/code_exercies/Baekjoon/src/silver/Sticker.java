package silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 9465
 * @link https://www.acmicpc.net/problem/9465
 */
public class Sticker {

    private static int[][] memory;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] values = new int[2][n];
            memory = new int[2][n];
            for (int row = 0; row < 2; row++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int col = 0; col < n; col++) {
                    values[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            for (int col = 0; col < n; col++) {
                for (int row = 0; row < 2; row++) {
                    calculateMemory(values, row, col);
                }
            }
            bw.write(Math.max(memory[0][n - 1], memory[1][n - 1]) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int calculateMemory(int[][] values, int row, int col) {
        if(memory[row][col] != 0) {
            return memory[row][col];
        }
        if (col == 0) {
            memory[row][col] = values[row][col];
            return memory[row][col];
        } else if(col == 1) {
            memory[row][col] = memory[(row + 1) % 2][col - 1] + values[row][col];
            return memory[row][col];
        }
        memory[row][col] = Math.max(memory[(row + 1) % 2][col - 1], memory[(row + 1) % 2][col - 2]) + values[row][col];
        return memory[row][col];
    }
}
