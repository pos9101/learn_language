package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baekjoon 16236
 * @link https://www.acmicpc.net/problem/16236
 */
public class BabyShark {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int size = 2;
    static int eatingCnt = 0;
    static int eatingTime = 0;
    static int remainFish;
    static int[][] steps = new int[][]{{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 9){
                    ++remainFish;
                }

            }
        }
        Moving shark = findShark(map);
        for (int i = 0; i < remainFish; i++) {
            if (shark == null) {
                break;
            }
            shark = bfs(shark.x, shark.y);
        }
        System.out.println(eatingTime);
        br.close();
    }

    private static Moving findShark(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 9) return new Moving(i, j, 0);
            }
        }
        return null;
    }

    private static Moving bfs(int sharkX, int sharkY) {
        //initialize visited
        for (boolean[] booleans : visited) {
            Arrays.fill(booleans, false);
        }
        PriorityQueue<Moving> queue = new PriorityQueue<>();
        queue.add(new Moving(sharkX, sharkY, 0));
        while (!queue.isEmpty()) {
            Moving poll = queue.poll();
            if(canEatFish(poll.x, poll.y)){
                ++eatingCnt;
                growShark();
                eatingTime += poll.steps;
                map[sharkX][sharkY] = 0;
                map[poll.x][poll.y] = 9;
                return new Moving(poll.x, poll.y, 0);
            }
            for (int[] step : steps) {
                int nextX = poll.x + step[0];
                int nextY = poll.y + step[1];
                if(canMove(nextX, nextY) && !visited[nextX][nextY] && throughWay(nextX, nextY)){
                    visited[nextX][nextY] = true;
                    queue.add(new Moving(nextX, nextY, poll.steps + 1));
                }
            }
        }
        return null;
    }

    private static boolean canEatFish(int x, int y) {
        return map[x][y] != 9 && map[x][y] != 0 && map[x][y] < size;
    }

    private static void growShark() {
        if(eatingCnt == size) {
            ++size;
            eatingCnt = 0;
        }
    }

    private static boolean throughWay(int nextX, int nextY) {
        return size >= map[nextX][nextY];
    }

    private static boolean canMove(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < N;
    }

    private static class Moving implements Comparable<Moving>{
        int x;
        int y;
        int steps;

        public Moving(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }

        @Override
        public int compareTo(Moving o) {
            int result = Integer.compare(this.steps, o.steps);
            if (result != 0) return result;
            result = Integer.compare(this.x, o.x);
            if (result != 0) return result;
            return Integer.compare(this.y, o.y);
        }
    }
}
