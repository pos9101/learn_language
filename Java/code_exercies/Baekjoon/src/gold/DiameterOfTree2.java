package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * baekjoon 1167
 * @link https://www.acmicpc.net/problem/1167
 */
public class DiameterOfTree2 {

    static boolean[] visited;
    static ArrayList<Node>[] tree;
    static int max = 0;
    static int endPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                tree[node].add(new Node(next, weight));
            }
        }
        visited[1] = true;
        dfs(1, 0);
        Arrays.fill(visited, false);
        max = 0;
        visited[endPoint] = true;
        dfs(endPoint, 0);
        System.out.println(max);
        br.close();
    }

    private static void dfs(int start, int distance) {
        for (Node next : tree[start]) {
            if (!visited[next.node]) {
                visited[next.node] = true;
                dfs(next.node, distance + next.weight);
            }
        }
        if (distance > max) {
            max = distance;
            endPoint = start;
        }
    }

    static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
