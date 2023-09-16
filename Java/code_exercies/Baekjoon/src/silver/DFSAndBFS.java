package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Baekjoon 1260
 * @link https://www.acmicpc.net/problem/1260
 */
public class DFSAndBFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N + 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        graph.doDFS(V);
        graph.doBFS(V);
        br.close();
    }



    static class Graph {
        private int nodeNum;
        LinkedList<Integer>[] adjacency;

        public Graph(int nodeNum) {
            this.nodeNum = nodeNum;
            this.adjacency = new LinkedList[nodeNum];
            for (int i = 0; i < nodeNum; i++) {
                adjacency[i] = new LinkedList<>();
            }
        }

        public void addEdge(int start, int end) {
            adjacency[start].add(end);
            adjacency[end].add(start);
        }

        public void doDFS(int start) {
            boolean[] visited = new boolean[nodeNum];
            Stack<Integer> stack = new Stack<>();
            StringJoiner sj = new StringJoiner(" ");
            stack.push(start);

            while(!stack.isEmpty()) {
                int node = stack.pop();
                if(!visited[node]) {
                    visited[node] = true;
                    sj.add(String.valueOf(node));
                    List<Integer> collect = adjacency[node].stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                    for (Integer value : collect) {
                        if(!visited[value]) {
                            stack.push(value);
                        }
                    }
                }
            }
            System.out.println(sj.toString());
        }
        public void doBFS(int start) {
            boolean[] visited = new boolean[nodeNum];
            Queue<Integer> queue = new LinkedList<>();
            StringJoiner sj = new StringJoiner(" ");

            visited[start] = true;
            queue.offer(start);
            while(!queue.isEmpty()) {
                Integer node = queue.poll();
                sj.add(String.valueOf(node));

                List<Integer> collect = adjacency[node].stream().sorted().collect(Collectors.toList());
                for (Integer value : collect) {
                    if(!visited[value]) {
                        visited[value] = true;
                        queue.offer(value);
                    }
                }
            }
            System.out.println(sj.toString());
        }
    }

}
