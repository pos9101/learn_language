package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 11724
 * @link https://www.acmicpc.net/problem/11724
 */
public class ConnectedComponentNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        Graph g = new Graph(N);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            g.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(g.bfs(i, visited)) {
                ++count;
            }
        }
        System.out.println(count);
        br.close();
    }

    public static class Graph {
        private int node;
        private ArrayList<Integer>[] connect;

        public Graph(int node) {
            this.node = node;
            connect = new ArrayList[node + 1];
            for (int i = 0; i <= node; i++) {
                connect[i] = new ArrayList<Integer>();
            }
        }

        public void addNode(int i, int j) {
            connect[i].add(j);
            connect[j].add(i);
        }

        public boolean bfs(int start, boolean[] visited) {
            if(visited[start]) {
                return false;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            while (!queue.isEmpty()) {
                int val = queue.poll();
                ArrayList<Integer> nextConnect = connect[val];
                for (Integer c : nextConnect) {
                    if(!visited[c]) {
                        queue.add(c);
                        visited[c] = true;
                    }
                }
            }
            return true;
        }


    }
}
