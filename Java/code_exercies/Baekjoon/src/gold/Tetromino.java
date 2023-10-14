package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 14500
 * @link https://www.acmicpc.net/problem/14500
 */
public class Tetromino {
    static int max = 0;
    static int maxOfBlock = 0;
    static int N, M;
    static boolean[][] visited;
    static int[][] moving = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] > maxOfBlock) maxOfBlock = area[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(area[i][j], area, visited, i, j, 1);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
        br.close();
    }

    private static void dfs(int sum, int[][] area, boolean[][] visited, int x, int y, int num) {
        if(num == 4) {
            if(sum > max) max = sum;
        }
        if ((4 - num) * maxOfBlock + sum <= max) {
            return;
        }
        for (int[] step : moving) {
            int nextX = x + step[0];
            int nextY = y + step[1];
            if(canMove(nextX, nextY) && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                if(num == 2) dfs(sum + area[nextX][nextY], area, visited, x, y, num + 1);
                dfs(sum + area[nextX][nextY], area, visited, nextX, nextY, num + 1);
                visited[nextX][nextY] = false;
            }
        }
    }

    private static boolean canMove(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}
