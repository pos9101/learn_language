package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 1987
 * @link https://www.acmicpc.net/problem/1987
 */
public class Alphabet {

    private static int max = 0;
    private static int[][] moving = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static int R;
    private static int C;
    private static boolean[][] visited;
    private static Map<Character, Boolean> visitedChar = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        visited[0][0] = true;
        visitedChar.put(map[0][0], true);
        dfs(map, 0, 0, 1);
        System.out.println(max);
        br.close();
    }

    private static void dfs(char[][] map, int x, int y, int count) {
        if (count > max) {
            max = count;
        }
        for (int[] step : moving) {
            int nextX = x + step[0];
            int nextY = y + step[1];
            if (canMove(nextX, nextY) && !visited[nextX][nextY] && !visitedChar.containsKey(map[nextX][nextY])) {
                visited[nextX][nextY] = true;
                visitedChar.put(map[nextX][nextY], true);
                dfs(map, nextX, nextY, count + 1);
                visited[nextX][nextY] = false;
                visitedChar.remove(map[nextX][nextY]);
            }
        }
    }

    private static boolean canMove(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < R && nextY < C;
    }
}
