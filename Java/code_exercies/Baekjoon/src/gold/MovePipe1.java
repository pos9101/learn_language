package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 17070
 * @link https://www.acmicpc.net/problem/17070
 */
public class MovePipe1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        //horizontal, vertical, diagonal
        int[][][] answer = new int[3][N + 1][N + 1];
        answer[0][1][2] = 1;
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp(map, answer, i, j);
            }
        }
        System.out.println(answer[0][N][N] + answer[1][N][N] + answer[2][N][N]);
        br.close();
    }

    private static void dp(int[][] map, int[][][] answer, int row, int col) {
        if (map[row][col] == 1) {
            return;
        }
        if (answer[0][row][col] != 0 || answer[1][row][col] != 0 || answer[2][row][col] != 0) {
            return;
        }
        //horizontal
        answer[0][row][col] = answer[0][row][col -1] + answer[2][row][col - 1];
        //vertical
        answer[1][row][col] = answer[1][row - 1][col] + answer[2][row - 1][col];
        //diagonal
        answer[2][row][col] = (canDiagonal(map, row, col) ? answer[0][row - 1][col - 1] + answer[1][row - 1][col - 1]
                + answer[2][row - 1][col - 1] : 0);
    }

    private static boolean canDiagonal(int[][] map, int row, int col) {
        return map[row -1][col] != 1 && map[row][col -1] != 1;
    }
}
