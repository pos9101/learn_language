package sprout;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 2738
 * @link https://www.acmicpc.net/problem/2738
 */
public class MatrixAddition {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        fillMatrixToZero(matrix);

        //2번 행렬 반복
        for(int k=0; k<2; k++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < M; j++) {
                    int value = Integer.parseInt(st.nextToken());
                    matrix[i][j] += value;
                }
            }
        }

        printMatrix(bw, matrix);

        bw.flush();

        br.close();
        bw.close();
    }

    private static void printMatrix(BufferedWriter bw, int[][] matrix) throws IOException {
        for(int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < row.length; j++) {
                sb.append(row[j] + " ");
            }
            bw.write(sb.toString().trim() + "\n");
        }
    }

    private static void fillMatrixToZero(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], 0);
        }
    }
}
