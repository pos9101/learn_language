package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 21736
 * @link https://www.acmicpc.net/problem/21736
 */
public class HunnaegiNeedFriend {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        char[][] array = new char[N][M];
        //[x, y]
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                array[i][j] = line.charAt(j);
                if(array[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        System.out.println(solveMeet(array, start));

        br.close();
    }

    private static String solveMeet(char[][] array, int[] start) {
        final int N = array.length;
        final int M = array[0].length;
        boolean[][] visited = new boolean[N][M];
        int[][] movePosition = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        queue.offer(start);
        while(!queue.isEmpty()) {
            int[] nowPosition = queue.poll();
            int x = nowPosition[0];
            int y = nowPosition[1];
            for (int[] step : movePosition) {
                int nextX = x + step[0];
                int nextY = y + step[1];
                if(canMove(nextX, nextY, N, M) && array[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.offer(new int[]{nextX, nextY});
                    if (array[nextX][nextY] == 'P') count++;
                }
            }
        }
        if(count == 0) return "TT";
        return String.valueOf(count);
    }

    private static boolean canMove(int nextX, int nextY, final int N, final int M) {
        return nextX >= 0 && nextY >= 0 && nextX < N && nextY < M;
    }
}
