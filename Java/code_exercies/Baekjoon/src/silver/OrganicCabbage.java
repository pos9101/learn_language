package silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 1012
 * @link https://www.acmicpc.net/problem/1012
 */
public class OrganicCabbage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] field = new int[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            bw.write(findMinWormNum(field) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int findMinWormNum(int[][] field) {
        final int M = field.length;
        final int N = field[0].length;
        boolean[][] visited = new boolean[M][N];
        int count = 0;
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                if (field[x][y] == 0 || visited[x][y]) {
                    continue;
                }
                bfs(field, visited, x, y);
                ++count;
            }
        }

        return count;
    }

    private static void bfs(int[][] field, boolean[][] visited, int x, int y) {
        Queue<Area> queue = new LinkedList<>();
        int[][] moving = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        queue.offer(new Area(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Area position = queue.poll();
            for (int[] step : moving) {
                int newX = position.getX() + step[0];
                int newY = position.getY() + step[1];
                if(canMove(field, newX, newY) && field[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new Area(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private static boolean canMove(int[][] field, int newX, int newY) {
        return newX >= 0 && newX < field.length && newY >= 0 && newY < field[0].length;
    }

    static class Area {
        private int x;
        private int y;

        public Area(int x, int y) {
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
