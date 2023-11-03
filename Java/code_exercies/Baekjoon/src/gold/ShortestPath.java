package gold;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 1753
 * @link https://www.acmicpc.net/problem/1753
 */
public class ShortestPath {

    private static final int MAX = 200000;
    private static int V;
    private static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(br.readLine());

        //not use 0
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            final int u = Integer.parseInt(st.nextToken());
            final int v = Integer.parseInt(st.nextToken());
            final int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }
        dijkstra(K);
        br.close();
    }

    private static void dijkstra(int k) throws IOException {
        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        Arrays.fill(distance, MAX);
        distance[k] = 0;
        priorityQueue.offer(new Node(k, 0));
        while (!priorityQueue.isEmpty()) {
            Node pollNode = priorityQueue.poll();
            if (distance[pollNode.position] < pollNode.distance) continue;
            for (Node nearNode : graph.get(pollNode.position)) {
                if (distance[nearNode.position] > distance[pollNode.position] + nearNode.distance) {
                    distance[nearNode.position] = distance[pollNode.position] + nearNode.distance;
                    priorityQueue.add(new Node(nearNode.position, distance[nearNode.position]));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= V; i++) {
            bw.write((distance[i] >= MAX ? "INF" : distance[i]) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node>{
        int position;
        int distance;
        public Node(int position, int distance) {
            this.position = position;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
