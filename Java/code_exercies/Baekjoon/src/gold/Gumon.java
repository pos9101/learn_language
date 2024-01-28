package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 1766
 * @link https://www.acmicpc.net/problem/1766
 */
public class Gumon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            ++sequence[b];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if(sequence[i] == 0) pq.add(i);
        }
        StringJoiner sj = new StringJoiner(" ");
        while(!pq.isEmpty()) {
            Integer poll = pq.poll();
            sj.add(String.valueOf(poll));

            for (Integer next : graph[poll]) {
                --sequence[next];
                if(sequence[next] == 0) pq.add(next);
            }
        }
        System.out.println(sj.toString());
        br.close();
    }
}
