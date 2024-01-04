package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 2166
 * @link https://www.acmicpc.net/problem/2166
 */
public class AreaOfPolygon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            queue.add(new Node(x, y));
        }

        long answer = 0;
        Node first = queue.poll();
        queue.add(first);
        long[][] calArr = new long[2][2];
        if (first == null) throw new AssertionError();
        calArr[0][0] = first.x;
        calArr[0][1] = first.y;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            calArr[1][0] = poll.x;
            calArr[1][1] = poll.y;

            //calculate  x1 * y2 - y1 * x2 .....
            answer += calArr[0][0] * calArr[1][1] - calArr[0][1] * calArr[1][0];

            calArr[0][0] = calArr[1][0];
            calArr[0][1] = calArr[1][1];
        }

        System.out.println(String.format("%.1f", Math.round(Math.abs(answer / 2.0) * 10) / 10.0));
        br.close();
    }

    static class Node {
        long x;
        long y;

        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
