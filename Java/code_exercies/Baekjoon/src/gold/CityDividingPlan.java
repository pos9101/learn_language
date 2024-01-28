package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Baekjoon 1647
 * @link https://www.acmicpc.net/problem/1647
 */
public class CityDividingPlan {
    static ArrayList<Node>[] graph;
    static int[] parents;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            final int C = Integer.parseInt(st.nextToken());
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        System.out.println(calculateMST(1));
        br.close();
    }

    private static int calculateMST(int start) {
        int mstValue = 0;
        int maxDistance = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Node n : graph[start]) {
            pq.offer(n);
        }
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if(find(start) == find(poll.v)) continue;
            union(start, poll.v);
            mstValue += poll.weight;
            if(poll.weight > maxDistance) maxDistance = poll.weight;
            for(Node next : graph[poll.v]) {
                if (find(next.v) == find(poll.v)) continue;
                pq.offer(next);
            }
        }
        return mstValue - maxDistance;
    }

    private static int find(int node) {
        if(parents[node] == node) return node;
        return find(parents[node]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return;
        if(rootA < rootB){
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
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
