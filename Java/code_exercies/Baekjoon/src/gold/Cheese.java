package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 2638
 * @link https://www.acmicpc.net/problem/2638
 */
public class Cheese {
    static final int[][] moving = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int N;
    static int M;
    static final int OUTER_AIR = 9;
    static final int CHEESE= 1;
    static final int VISITED_CHEESE= 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs(array, 0, 0));
        br.close();
    }

    private static int bfs(int[][] array, int startX, int startY) {
        int hours = 0;
        Queue<int[]> airQueue = new LinkedList<>();
        Queue<int[]> cheeseQueue = new LinkedList<>();
        airQueue.add(new int[]{startX, startY});
        while(true) {
            if (airQueue.isEmpty()) {
                break;
            }
            //outer air routine
            while (!airQueue.isEmpty()) {
                int[] poll = airQueue.poll();
                for (int[] step : moving) {
                    int nextX = poll[0] + step[0];
                    int nextY = poll[1] + step[1];
                    if (canMove(nextX, nextY)) {
                        if (array[nextX][nextY] == 0) {
                            array[nextX][nextY] = OUTER_AIR;
                            airQueue.add(new int[]{nextX, nextY});
                        } else if (array[nextX][nextY] == 1) {
                            array[nextX][nextY] = VISITED_CHEESE;
                            cheeseQueue.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            if (cheeseQueue.isEmpty()) break;
            //outside cheese routine
            while (!cheeseQueue.isEmpty()) {
                int[] poll = cheeseQueue.poll();
                array[poll[0]][poll[1]] = CHEESE;
                int nearAirCnt = 0;
                for (int[] step : moving) {
                    int nextX = poll[0] + step[0];
                    int nextY = poll[1] + step[1];
                    if (canMove(nextX, nextY) && array[nextX][nextY] == OUTER_AIR) {
                        ++nearAirCnt;
                    }
                }
                if (nearAirCnt >= 2) {
                    airQueue.add(new int[]{poll[0],poll[1]});
                }
            }
            //melt Cheeses
            for (int[] val : airQueue) {
                array[val[0]][val[1]] = OUTER_AIR;
            }
            ++hours;
        }
        return hours;
    }

    private static boolean canMove(int nextX, int nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}
