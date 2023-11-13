package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 2206
 * @link https://www.acmicpc.net/problem/2206
 */
public class MoveBreakingWall {

    private static boolean[][] brokenVisited;
    private static boolean[][] visited;
    private static boolean[][] walls;
    private static int[][] moving = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static int shortDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        walls = new boolean[N + 1][M + 1];
        brokenVisited = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') {
                    walls[i][j + 1] = true;
                }
            }
        }
        bfs(1, 1, N, M);
        System.out.println((shortDistance == Integer.MAX_VALUE) ? -1 : shortDistance);
        br.close();
    }

    private static void bfs(int startX, int startY, int targetX, int targetY) {
        //initialize visited
        for (int i = 1; i < brokenVisited.length; i++) {
            Arrays.fill(brokenVisited[i], false);
            Arrays.fill(visited[i], false);
        }
        Arrays.fill(brokenVisited[0], true);
        Arrays.fill(visited[0], true);
        for (int i = 1; i <= targetX; i++) {
            brokenVisited[i][0] = true;
            visited[i][0] = true;
        }

        Queue<List<int[]>> queue = new LinkedList<>();
        List<int[]> first = new ArrayList<>();
        int count = 0;
        brokenVisited[startX][startY] = true;
        visited[startX][startY] = true;
        first.add(new int[]{startX, startY, 0});
        queue.add(first);
        while (!queue.isEmpty()) {
            List<int[]> poll = queue.poll();
            ++count;
            List<int[]> nextList = new ArrayList<>();
            for (int[] axis : poll) {
                int nowX = axis[0];
                int nowY = axis[1];
                int brokenWalls = axis[2];
                if(nowX == targetX && nowY == targetY) {
                    if(count < shortDistance) shortDistance = count;
                    return;
                }
                for (int[] step : moving) {
                    int nextX = nowX + step[0];
                    int nextY = nowY + step[1];
                    if (canMove(nextX, nextY, targetX, targetY) && !visited[nextX][nextY] && brokenWalls < 2) {
                        if(brokenWalls == 0) {
                            visited[nextX][nextY] = true;
                            nextList.add(new int[]{nextX, nextY, walls[nextX][nextY]? brokenWalls + 1 : brokenWalls});
                        } else if (brokenWalls == 1 && !brokenVisited[nextX][nextY] && !walls[nextX][nextY]) {
                            brokenVisited[nextX][nextY] = true;
                            nextList.add(new int[]{nextX, nextY, brokenWalls});
                        }
                    }
                }
            }
            if (!nextList.isEmpty()) {
                queue.offer(nextList);
            }
        }
    }

    private static boolean canMove(int nextX, int nextY, int N, int M) {
        return nextX >= 0 && nextY >= 0 && nextX <= N && nextY <= M;
    }
}

