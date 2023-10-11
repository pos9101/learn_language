package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 7569
 * @link https://www.acmicpc.net/problem/7569
 */
public class Tomato3D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        final int H = Integer.parseInt(st.nextToken());
        int[][][] tomatoBox = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        int day = 0;
        Queue<List<int[]>> queue = new LinkedList<>();
        List<int[]> firstDayList = new ArrayList<>();
        int[][] moving = new int[][]{{-1, 0, 0}, {0, -1, 0}, {0, 0, -1}, {1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatoBox[i][j][k] = tomato;
                    if(tomato == 1) {
                        visited[i][j][k] = true;
                        firstDayList.add(new int[]{i, j, k});
                    }
                }
            }
        }
        if(!firstDayList.isEmpty()) {
            queue.add(firstDayList);
        }
        while(!queue.isEmpty()) {
            List<int[]> todayPositions = queue.poll();
            List<int[]> nextDayList = new ArrayList<>();
            for (int[] position : todayPositions) {
                for (int[] step : moving) {
                    int newX = position[0] + step[0];
                    int newY = position[1] + step[1];
                    int newZ = position[2] + step[2];
                    if(canMove(newX, newY, newZ, H, N, M) && tomatoBox[newX][newY][newZ] == 0 && !visited[newX][newY][newZ]) {
                        visited[newX][newY][newZ] = true;
                        nextDayList.add(new int[]{newX, newY, newZ});
                    }
                }
            }
            if(!nextDayList.isEmpty()) {
                ++day;
                queue.add(nextDayList);
            }
        }
        day = (existUncooked(tomatoBox, visited, H, N, M)) ? -1 : day;
        System.out.println(day);
        br.close();
    }

    private static boolean canMove(int newX, int newY, int newZ, final int H, final int N, final int M) {
        return newX >= 0 && newY >= 0 && newZ >= 0 && newX < H && newY < N && newZ < M;
    }

    private static boolean existUncooked(int[][][] tomatoBox, boolean[][][] visited, int H, int N, int M) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(!visited[i][j][k] && tomatoBox[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
