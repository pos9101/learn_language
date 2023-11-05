package silver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Baekjoon 11725
 * @link https://www.acmicpc.net/problem/11725
 */
public class FindParentOfTree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        Node[] graph = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new Node(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].connection.add(b);
            graph[b].connection.add(a);
        }
        findParent(graph, 1);
        for (int i = 2; i < graph.length ; i++) {
            bw.write(graph[i].parent +"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void findParent(Node[] graph, int start) {
        Node presentNode = graph[start];
        for (Integer value : presentNode.connection) {
            if(graph[value].parent == 0) {
                graph[value].parent = start;
                findParent(graph, value);
            }
        }
    }

    public static class Node {
        int point;
        int parent = 0;
        List<Integer> connection;
        public Node(int point, List<Integer> connection) {
            this.point = point;
            this.connection = connection;
        }

    }
}
