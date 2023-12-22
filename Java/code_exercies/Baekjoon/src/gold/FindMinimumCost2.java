package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 11779
 * @link https://www.acmicpc.net/problem/11779
 */
public class FindMinimumCost2 {
    static ArrayList<Node>[] graph;
    static int[] way;
    static int[] shortest;
    static final int MAX = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        way = new int[n + 1];
        shortest = new int[n + 1];
        Arrays.fill(shortest, MAX);
        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int arrival = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());
        findShortest(arrival);
        System.out.println(shortest[destination]);
        Stack<Integer> wayStack = new Stack<>();
        int backward = destination;
        wayStack.push(destination);
        while(true){
            backward = way[backward];
            wayStack.push(backward);
            if(backward == arrival) break;
        }
        StringJoiner sj = new StringJoiner(" ");
        int count = 0;
        while (!wayStack.isEmpty()) {
            sj.add(String.valueOf(wayStack.pop()));
            ++count;
        }
        System.out.println(count);
        System.out.println(sj.toString());
        br.close();
    }

    private static void findShortest(int arrival) {
        shortest[arrival] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(arrival, 0));
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int node = poll.v;
            int cost = poll.weight;
            if (cost > shortest[node]) {
                continue;
            }
            for(Node next : graph[node]) {
                if (cost + next.weight < shortest[next.v]) {
                    way[next.v] = node;
                    shortest[next.v] = cost + next.weight;
                    pq.offer(new Node(next.v, shortest[next.v]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }
}
