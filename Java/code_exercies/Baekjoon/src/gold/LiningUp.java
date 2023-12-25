package gold;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 2252
 * @link https://www.acmicpc.net/problem/2252
 */
public class LiningUp {
    static BufferedWriter bw;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] connectedNum = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            graph[front].add(back);
            ++connectedNum[back];
        }
        topologicalSorting(graph, connectedNum);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void topologicalSorting(ArrayList<Integer>[] graph, int[] connectedNum) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 1; i < connectedNum.length; i++) { //1 ~ N
            if(connectedNum[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            sj.add(String.valueOf(poll));
            for(int connected : graph[poll]) {
                --connectedNum[connected];
            }
            for (int i = 1; i < connectedNum.length; i++) {
                if(connectedNum[i] == 0 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        bw.write(sj.toString());
    }
}
