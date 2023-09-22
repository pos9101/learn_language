package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 7576
 * @link https://www.acmicpc.net/problem/7576
 */
public class Tomato {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        int[][] tomatoBox = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(calculateDays(tomatoBox, N, M));
        br.close();
    }

    private static int calculateDays(int[][] tomatoBox, final int N, final int M) {
        int days = 0;
        int remainNum = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<List<Position>> queue = new LinkedList<>();
        int[][] moving = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        List<Position> rotten = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                switch (tomatoBox[i][j]) {
                    case 0:
                        ++remainNum;
                        break;
                    case 1:
                        visited[i][j] = true;
                        rotten.add(new Position(i, j));
                        break;
                    case -1:
                    default:
                        visited[i][j] = true;
                        break;
                }
            }
        }
        if(remainNum == 0) {
            return 0;
        }
        queue.offer(rotten);

        while (!queue.isEmpty()) {
            List<Position> rottens = queue.poll();
            List<Position> soonRottens = new ArrayList<>();
            for (Position position : rottens) {
                int x = position.getX();
                int y = position.getY();
                for (int[] step : moving) {
                    int newX = x + step[0];
                    int newY = y + step[1];
                    if (canMove(newX, newY, N, M) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        --remainNum;
                        soonRottens.add(new Position(newX, newY));
                    }
                }
            }
            if(!soonRottens.isEmpty()) {
                ++days;
                queue.offer(soonRottens);
            }
        }
        if (remainNum > 0) return -1;
        return days;

    }

    private static boolean canMove(int newX, int newY, final int N, final int M) {
        return newX >= 0 && newX < N && newY >= 0 && newY < M;
    }

    public static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
