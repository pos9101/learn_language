package gold;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Baekjoon 1865
 * @link https://www.acmicpc.net/problem/1865
 */
public class Wormhole {
    private static BufferedReader br;
    private static int N;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            bw.write(isTimeWarf() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static String isTimeWarf() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int W = Integer.parseInt(st.nextToken());
        int[] shortest = new int[N + 1];
        ArrayList<Node> graph = new ArrayList<>();
        //road
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            final int S = Integer.parseInt(st.nextToken());
            final int E = Integer.parseInt(st.nextToken());
            final int T = Integer.parseInt(st.nextToken());
            graph.add(new Node(S, E, T));
            graph.add(new Node(E, S, T));
        }
        //wormhole
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            final int S = Integer.parseInt(st.nextToken());
            final int E = Integer.parseInt(st.nextToken());
            final int T = Integer.parseInt(st.nextToken());
            graph.add(new Node(S, E, -T));
        }
        if (loopBellmanFord(shortest, graph)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean loopBellmanFord(int[] shortest, ArrayList<Node> graph) {
        for (int j = 1; j <= N; j++) {
            for (Node node : graph) {
                if (shortest[node.end] > shortest[node.start] + node.time) {
                    shortest[node.end] = shortest[node.start] + node.time;
                    if (j == N) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Node {
        int start;
        int end;
        int time;

        public Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
