package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 1967
 * @link https://www.acmicpc.net/problem/1967
 */
public class DiameterOfTree {

    private static ArrayList<Node>[] tree;
    private static boolean visited[];
    private static int longestDistance;
    private static int longestNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }
        visited[1] = true;
        dfs(1, 0);
        Arrays.fill(visited, false);
        longestDistance = 0;
        visited[longestNode] = true;
        dfs(longestNode, 0);
        System.out.println(longestDistance);
        br.close();
    }

    private static void dfs(int node, int distance) {
        for (Node next : tree[node]) {
            if (!visited[next.node]) {
                visited[next.node] = true;
                dfs(next.node, distance + next.weight);
            }
        }

        if (distance > longestDistance) {
            longestDistance = distance;
            longestNode = node;
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
