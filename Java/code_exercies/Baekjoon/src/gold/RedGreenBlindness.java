package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Baekjoon 10026
 * @link https://www.acmicpc.net/problem/10026
 */
public class RedGreenBlindness {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        char[][] array = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                 array[i][j] = line.charAt(j);
            }
        }

        System.out.println(solveArea(array, N));
        br.close();
    }

    private static String solveArea(char[][] array, final int N) {
        boolean[][] visitedNormal = new boolean[N][N];
        boolean[][] visitedBlind = new boolean[N][N];
        int countNormal = 0;
        int countBlind = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                countNormal += bfs(array, visitedNormal, i, j);
                countBlind += bfsB(array, visitedBlind, i, j);
            }
        }
        return countNormal + " " + countBlind;
    }

    private static int bfs(char[][] array, boolean[][] visited, int startX, int startY) {
        if(visited[startX][startY]) {
            return 0;
        }
        final int N = array.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] movingPosition = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        char findChar = array[startX][startY];
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int nowX = position[0];
            int nowY = position[1];
            for (int[] step : movingPosition) {
                int nextX = nowX + step[0];
                int nextY = nowY + step[1];
                if (canMove(nextX, nextY, N) && !visited[nextX][nextY] && array[nextX][nextY] == findChar) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return 1;
    }

    private static int bfsB(char[][] array, boolean[][] visited, int startX, int startY) {
        if(visited[startX][startY]) {
            return 0;
        }
        final int N = array.length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] movingPosition = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        boolean isBlue = array[startX][startY] == 'B';
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int nowX = position[0];
            int nowY = position[1];
            for (int[] step : movingPosition) {
                int nextX = nowX + step[0];
                int nextY = nowY + step[1];
                if (canMove(nextX, nextY, N) && !visited[nextX][nextY] && ((array[nextX][nextY] == 'B') == isBlue)) {
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return 1;
    }

    private static boolean canMove(int nextX, int nextY, final int N) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < N;
    }
}