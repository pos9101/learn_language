package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 11049
 * @link https://www.acmicpc.net/problem/11049
 */
public class MatrixMultiplySequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        long[][] memory = new long[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memory[i], Long.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) {
            memory[i][i] = 0;
        }

        for (int difference = 1; difference < N; difference++) {
            for (int first = 0; first < N - difference; first++) {
                int second = first + difference;
                for (int m = first; m < second; m++) {
                    memory[first][second] = Math.min(memory[first][second],
                            memory[first][m] + memory[m + 1][second] + calMatrix(matrix, first, m, second)
                            );
                }
            }
        }
        System.out.println(memory[0][N - 1]);
        br.close();
    }

    private static int calMatrix(int[][] matrix, int first, int m, int second) {
        return matrix[first][0] * matrix[m][1] * matrix[second][1];
    }
}
