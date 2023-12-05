package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baekjoon 1916
 * @link https://www.acmicpc.net/problem/1916
 */
public class FindMinimumCost {
    static final int MAX = 1000000000;
    static int[] costs;
    static ArrayList<Node>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        costs = new int[N + 1];
        Arrays.fill(costs, MAX);
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[start].add(new Node(end, cost));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        costs[startCity] = 0;
        dijkstra(startCity);
        System.out.println(costs[endCity]);
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int node = poll.destination;
            int weight = poll.weight;
            if (weight > costs[node]) {
                continue;
            }
            for(Node nextNode : tree[node]) {
                if (weight + nextNode.weight < costs[nextNode.destination]) {
                    costs[nextNode.destination] = weight + nextNode.weight;
                    pq.offer(new Node(nextNode.destination, costs[nextNode.destination]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int destination;
        int weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
