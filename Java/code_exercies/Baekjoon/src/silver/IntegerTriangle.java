package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1932
 * @link https://www.acmicpc.net/problem/1932
 */
public class IntegerTriangle {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] triangle = new int[N][N];
        int[][] maxMemory = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(takeMax(maxMemory, triangle, 0, 0));
        br.close();
    }

    private static int takeMax(int[][] maxMemory, int[][] triangle, int row, int col) {
        if(maxMemory[row][col] != 0) {
            return maxMemory[row][col];
        }
        if(maxMemory.length - 1 == row) {
            maxMemory[row][col] = triangle[row][col];
            return maxMemory[row][col];
        }
        maxMemory[row][col] = triangle[row][col] + Math.max(takeMax(maxMemory, triangle, row + 1, col), takeMax(maxMemory, triangle, row + 1, col + 1));
        return maxMemory[row][col];
    }
}
