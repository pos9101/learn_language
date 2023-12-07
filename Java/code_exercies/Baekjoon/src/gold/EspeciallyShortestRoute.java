package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baekjoon 1504
 * @link https://www.acmicpc.net/problem/1504
 */
public class EspeciallyShortestRoute {
    static int N, v1, v2, v1v2Route = 0, v2v1Route = 0;
    static final int MAX = 8000001;
    static ArrayList<Node>[] graph;
    static int[] shortest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        final int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        shortest = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        findStartToV1AndV2();
        findShortestRoadBetweenV1andV2();
        findShortestRoadFromAllToN();
        int answer = v1v2Route < v2v1Route ? v1v2Route : v2v1Route;
        System.out.println(answer < MAX ? answer : -1);
        br.close();
    }

    /**
     * find the shortest route from 1 to v1 and v2
     */
    private static void findStartToV1AndV2() {
        Arrays.fill(shortest, MAX);
        dijkstra(1);
        v1v2Route += shortest[v1];
        v2v1Route += shortest[v2];
    }

    /**
     * find the shortest route from v1 to v2 (same from v2 to v1)
     */
    private static void findShortestRoadBetweenV1andV2() {
        Arrays.fill(shortest, MAX);
        dijkstra(v1);
        v1v2Route += shortest[v2];
        v2v1Route += shortest[v2];
    }

    /**
     * find the shortest route from N to v1 and v2 (same from v1 and v2 to N)
     */
    private static void findShortestRoadFromAllToN() {
        Arrays.fill(shortest, MAX);
        dijkstra(N);
        v1v2Route += shortest[v2];
        v2v1Route += shortest[v1];
    }

    private static void dijkstra(int index) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        shortest[index] = 0;
        pq.add(new Node(index, 0));
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int v = poll.v;
            int weight = poll.weight;
            if (weight > shortest[v]) {
                continue;
            }
            for (Node next : graph[v]) {
                if (weight + next.weight < shortest[next.v]) {
                    shortest[next.v] = weight + next.weight;
                    pq.offer(new Node(next.v, shortest[next.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
