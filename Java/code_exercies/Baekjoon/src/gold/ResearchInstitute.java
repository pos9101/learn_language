package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 14502
 * @link https://www.acmicpc.net/problem/14502
 */
public class ResearchInstitute {

    private static boolean[][] visited;
    private static int max = 0;
    private static int N;
    private static int M;

    private static int[][] moving = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        madeWall(map, 0, 0, 0);
        System.out.println(max);
        br.close();
    }

    private static void madeWall(int[][] map, int rowNum, int colNum, int wallNum) {
        if(wallNum == 3) {
            bfs(map);
            return;
        }
        if (rowNum == N) {
            return;
        }
        int nextRow;
        int nextCol;
        for (int j = colNum; j < M; j++) {
            if (map[rowNum][j] == 0) {
                map[rowNum][j] = 1;
                nextRow = findNextRow(rowNum, j);
                nextCol = findNextCol(rowNum, j);
                madeWall(map, nextRow, nextCol, wallNum + 1);
                map[rowNum][j] = 0;
            }
        }
        for (int j = 0; j < M; j++) {
        for (int i = rowNum + 1; i < N; i++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    nextRow = findNextRow(i, j);
                    nextCol = findNextCol(i, j);
                    madeWall(map, nextRow, nextCol, wallNum + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int findNextRow(int rowNum, int colNum) {
        if (colNum == M - 1) {
            return rowNum + 1;
        } else {
            return rowNum;
        }
    }

    private static int findNextCol(int rowNum, int colNum) {
        if (colNum == M - 1) {
            return 0;
        } else {
            return ++colNum;
        }
    }

    private static void bfs(int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] step : moving) {
                int nextX = point[0] + step[0];
                int nextY = point[1] + step[1];
                if (canMove(nextX, nextY) && !visited[nextX][nextY] && map[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    ++count;
                }
            }
        }
        if (count > max) {
            max = count;
        }

    }

    private static boolean canMove(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}
