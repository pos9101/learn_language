package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baekjoon 13460
 * @link https://www.acmicpc.net/problem/13460
 */
public class EscapeBead2 {
    static char[][] map;
    static int[][] moving = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                switch (map[i][j]) {
                    case 'R' -> queue.add(new Node('R', i, j, 0));
                    case 'B' -> queue.add(new Node('B', i, j, 0));
                    default -> { /*do nothing */ }
                }
            }
        }
        //bfs
        int answer = 10;
        boolean isExitRed = false;
        boolean isExitBlue = false;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.color + " " + poll.x + " " +poll.y);
            int count = poll.count;
            if (count == 10 || count >= answer) continue;
            for (int[] step : moving) {
                int nextX = poll.x + step[0];
                int nextY = poll.y + step[1];
                //case which can move
                if((map[nextX][nextY] == 'R' || map[nextX][nextY] == 'B')
                        && map[nextX + step[0]][nextY + step[1]] == '.') {
                    System.out.println("hello");
                    queue.add(new Node(poll.color, poll.x, poll.y, count));
                    continue;
                }
                while (map[nextX][nextY] == '.') {
                    nextX += step[0];
                    nextY += step[1];
                }
                //case which is same area
                if(poll.x == nextX - step[0] && poll.y == nextY - step[1]) continue;
                switch (map[nextX][nextY]) {
                    case 'O':
                        if (poll.color == 'B') {
                            isExitBlue = true;
                        } else {
                            isExitRed = true;
                            answer = count + 1;
                        }
                        map[poll.x][poll.y] = '.';
                        break;
                    case 'R':
                    case 'B':
                    case '#':
                        map[poll.x][poll.y] = '.';
                        map[nextX - step[0]][nextY - step[1]] = poll.color;
                        queue.add(new Node(poll.color, nextX - step[0], nextY - step[1], count + 1));
                        break;
                }
            }
        }
        if(!isExitRed) {
            System.out.println(-1);
        } else {
            if(isExitBlue) {
                System.out.println(-1);
            } else {
                System.out.println(answer);
            }
        }
        br.close();
    }
    static class Node implements Comparable<Node> {
        char color;
        int x;
        int y;
        int count;

        public Node(char color, int x, int y, int count) {
            this.color = color;
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.count, o.count);
        }
    }
}
