package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 2178
 * @link https://www.acmicpc.net/problem/2178
 */
public class SearchMaze {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        // (0, 0) -> (N-1, M-1)
        int[][] maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
        int startX = 0;
        int startY = 0;
        System.out.println(findMazeDistance(maze, startX, startY, N, M));
        br.close();
    }

    private static int findMazeDistance(int[][] maze, int startX, int startY, final int N, final int M) {
        boolean[][] isVisited = new boolean[N][M];
        int[][] distance = new int[N][M];
        int[][] location = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        isVisited[startX][startY] = true;
        distance[startX][startY] = 1;
        while(!queue.isEmpty()) {
            int[] present = queue.poll();
            for (int[] step : location) {
                if(canMove(maze, isVisited, present, step)) {
                    int newX = present[0] + step[0];
                    int newY = present[1] + step[1];
                    distance[newX][newY] = distance[present[0]][present[1]] + 1;
                    if(newX == N-1 && newY == M-1){
                        return distance[newX][newY];
                    }
                    queue.offer(new int[]{newX, newY});
                    isVisited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

    private static boolean canMove(int[][] maze, boolean[][] isVisited, int[] before, int[] step) {
        int newX = before[0] + step[0];
        int newY = before[1] + step[1];
        if(newX < 0 || newY < 0) {
            return false;
        }
        if(newX > isVisited.length - 1 || newY > isVisited[0].length -1) {
            return false;
        }
        if(isVisited[newX][newY]) {
            return false;
        }
        if(maze[newX][newY] == 0) {
            return false;
        }
        return true;
    }
}
