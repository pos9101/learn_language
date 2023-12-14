package gold;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 10830
 * @link https://www.acmicpc.net/problem/10830
 */
public class MatrixPow {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) temp[i][j] = 1;
            }
        }
        while (b > 0) {
            if (b % 2 == 1) {
                temp = multiplyMatrix(matrix, temp);
            }
            matrix = multiplyMatrix(matrix, matrix);
            b /= 2;
        }

        for (int[] row : temp) {
            StringJoiner sj = new StringJoiner(" ");
            for (int val : row) {
                sj.add(String.valueOf(val));
            }
            bw.write(sj.toString() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    //n by n
    private static int[][] multiplyMatrix(int[][] temp, int[][] matrix) {
        int[][] returnMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //calculate returnMatrix[i][j] of matrix
                for (int index = 0; index < N; index++) {
                    returnMatrix[i][j] += temp[i][index] * matrix[index][j];
                }
                returnMatrix[i][j] %= 1000;
            }
        }
        return returnMatrix;
    }
}
