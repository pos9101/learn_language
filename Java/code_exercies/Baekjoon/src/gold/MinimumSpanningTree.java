package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baekjoon 1197
 * @link https://www.acmicpc.net/problem/1197
 */
public class MinimumSpanningTree {
    static boolean[] connected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());
        connected = new boolean[V + 1];
        ArrayList<Node>[] graph = new ArrayList[V + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, weight));
            graph[b].add(new Node(a, weight));
        }
        prim(graph, 1);
        br.close();
    }

    private static void prim(ArrayList<Node>[] graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        connected[start] = true;
        int answer = 0;
        pq.addAll(graph[start]);
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int v = poll.v;
            int cost = poll.cost;
            if(connected[v]) continue;
            connected[v] = true;
            answer += cost;
            for(Node next : graph[v]) {
                if (!connected[next.v]) {
                    pq.add(new Node(next.v, next.cost));
                }
            }
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        final int v;
        final int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
