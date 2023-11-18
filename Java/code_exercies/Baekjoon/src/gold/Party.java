package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 1238
 * @link https://www.acmicpc.net/problem/1238
 */
public class Party {

    private static final int MAX = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int X = Integer.parseInt(st.nextToken());

        List<List<Node>> graphForward = new ArrayList<>();
        List<List<Node>> graphReverse = new ArrayList<>();
        int[] answerForward = new int[N + 1];
        int[] answerReverse = new int[N + 1];
        Arrays.fill(answerForward, MAX);
        Arrays.fill(answerReverse, MAX);

        //not use graph(0) X, use graph(1) ~ graph(n)
        for (int i = 0; i <= N; i++) {
            graphForward.add(new ArrayList<>());
            graphReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            final int start = Integer.parseInt(st.nextToken());
            final int end = Integer.parseInt(st.nextToken());
            final int cost = Integer.parseInt(st.nextToken());
            graphForward.get(start).add(new Node(end, cost));
            graphReverse.get(end).add(new Node(start, cost));
        }
        dijkstra(X, graphForward, answerForward);
        dijkstra(X, graphReverse, answerReverse);
        int lostTime = 0;
        for (int i = 1; i <= N; i++) {
            int dijkstraSum = answerForward[i] + answerReverse[i];
            if (dijkstraSum > lostTime) {
                lostTime = dijkstraSum;
            }
        }
        System.out.println(lostTime);
        br.close();
    }

    private static void dijkstra(int index, List<List<Node>> graph, int[] answer) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        answer[index] = 0;
        queue.offer(new Node(index, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int node = poll.v;
            int cost = poll.cost;
            if (cost > answer[node]) {
                continue;
            }
            for (Node nextNode : graph.get(node)) {
                if (cost + nextNode.cost < answer[nextNode.v]) {
                    answer[nextNode.v] = cost + nextNode.cost;
                    queue.offer(new Node(nextNode.v, answer[nextNode.v]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {

        private int v;
        private int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
