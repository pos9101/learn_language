package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 2589
 * @link https://www.acmicpc.net/problem/2589
 */
public class TreasureIsland {
    static int row;
    static int col;
    static int distance;
    static int[][] move = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        char[][] array = new char[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                array[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(array[i][j] == 'L') {
                    int[] expectedTreasure1 = bfs(array, visited, new int[]{i, j}, true);
                    int[] expectedTreasure2 = bfs(array, visited, expectedTreasure1, true);
                    if(expectedTreasure2[2] > distance) distance = expectedTreasure2[2];
                }
            }
        }
        System.out.println(distance);
        br.close();
    }

    private static int[] bfs(char[][] array, boolean[][] visited, int[] startPoint, boolean visitedReset){
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> bfsVisited = new ArrayList<>();
        int[] value = new int[]{startPoint[0], startPoint[1], 0};
        visited[startPoint[0]][startPoint[1]] = true;
        bfsVisited.add(new int[]{startPoint[0], startPoint[1]});
        queue.add(value);
        while(!queue.isEmpty()) {
            value = queue.poll();
            for (int[] step : move) {
                int nextX = value[0] + step[0];
                int nextY = value[1] + step[1];
                if (canMove(nextX, nextY) && !visited[nextX][nextY] && array[nextX][nextY] == 'L') {
                    visited[nextX][nextY] = true;
                    bfsVisited.add(new int[]{nextX, nextY});
                    queue.add(new int[]{nextX, nextY, value[2] + 1});
                }
            }
        }
        if(visitedReset) {
            for (int[] v : bfsVisited) {
                visited[v[0]][v[1]] = false;
            }
        }
        return value;
    }

    private static boolean canMove(int nextX, int nextY) {
        return nextX >= 0 && nextX < row && nextY >= 0 && nextY < col;
    }

    private static int[] findNonVisitedIsland(char[][] array, boolean[][] visited) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(!visited[i][j] && array[i][j] == 'L') return new int[]{i, j};
            }
        }
        return null;
    }
}
