package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 13460
 * @link https://www.acmicpc.net/problem/13460
 */
public class EscapeBead2 {
    static char[][] map;
    static int[][] moving = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int answer = 11;
    static int N;
    static int M;
    static boolean[][][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Queue<PositionAndCnt> queue = new LinkedList<>();
        int xRed = 0, yRed = 0, xBlue = 0, yBlue = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                switch (map[i][j]) {
                    case 'R':
                        xRed = i;
                        yRed = j;
                        break;
                    case 'B':
                        xBlue = i;
                        yBlue = j;
                        break;
                    default :
                        break;
                }
            }
        }
        visited = new boolean[N][M][N][M];
        visited[xRed][yRed][xBlue][yBlue] = true;
        queue.add(new PositionAndCnt(xRed, yRed, xBlue, yBlue, 0));
        bfs(queue);
        if(answer == 11) System.out.println(-1);
        br.close();
    }

    static void bfs(Queue<PositionAndCnt> queue) {
        //first Red, last Blue
        while (!queue.isEmpty()) {
            PositionAndCnt poll = queue.poll();
            int count = poll.count;
            if (count == 10) continue;
            for (int[] step : moving) {
                int nextRedX = poll.xRed;
                int nextRedY = poll.yRed;
                int nextBlueX = poll.xBlue;
                int nextBlueY = poll.yBlue;

                //move
                while (map[nextRedX + step[0]][nextRedY + step[1]] != '#') {
                    nextRedX += step[0];
                    nextRedY += step[1];
                    if(map[nextRedX][nextRedY] == 'O') break;
                }
                while (map[nextBlueX + step[0]][nextBlueY + step[1]] != '#') {
                    nextBlueX += step[0];
                    nextBlueY += step[1];
                    if(map[nextBlueX][nextBlueY] == 'O') break;
                }

                if(map[nextBlueX][nextBlueY] == 'O') continue;
                if(map[nextRedX][nextRedY] == 'O') {
                    answer = count + 1;
                    System.out.println(answer);
                    return;
                }

                //case that red and blue are same position.
                if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
                    if(moveDistance(poll.xRed, poll.yRed, nextRedX, nextRedY)
                            > moveDistance(poll.xBlue, poll.yBlue, nextBlueX, nextBlueY)) {
                        nextRedX -= step[0];
                        nextRedY -= step[1];
                    } else {
                        nextBlueX -= step[0];
                        nextBlueY -= step[1];
                    }
                }
                if(!visited[nextRedX][nextRedY][nextBlueX][nextBlueY]) {
                    visited[nextRedX][nextRedY][nextBlueX][nextBlueY] = true;
                    queue.add(new PositionAndCnt(nextRedX, nextRedY, nextBlueX, nextBlueY, count + 1));
                }
            }
        }
    }

    private static int moveDistance(int originX, int originY, int afterX, int afterY) {
        return Math.abs(afterX - originX) + Math.abs(afterY - originY);
    }

    static class PositionAndCnt {
        int xRed;
        int yRed;
        int xBlue;
        int yBlue;
        int count;

        public PositionAndCnt(int xRed, int yRed, int xBlue, int yBlue, int count) {
            this.xRed = xRed;
            this.yRed = yRed;
            this.xBlue = xBlue;
            this.yBlue = yBlue;
            this.count = count;
        }

    }
}
