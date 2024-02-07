package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Baekjoon 2623
 * @link https://www.acmicpc.net/problem/2623
 */
public class MusicProgram {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] connected = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        IntStream.rangeClosed(1, N).forEach(i -> graph[i] = new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int beforeSingerIdx = 0;
            for (int idx = 0; idx < num; idx++) {
                int singerIdx = Integer.parseInt(st.nextToken());
                if (beforeSingerIdx != 0) {
                    ++connected[singerIdx];
                    graph[beforeSingerIdx].add(singerIdx);
                }
                beforeSingerIdx = singerIdx;
            }
        }
        solveSequence(connected, graph);
        br.close();
    }

    private static void solveSequence(int[] connected, ArrayList<Integer>[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        LinkedHashSet<Integer> answer = new LinkedHashSet<>();
        IntStream.rangeClosed(1, N).filter(x -> connected[x] == 0)
                .forEach(val -> queue.add(val));
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            answer.add(poll);
            for(int next : graph[poll]) {
                --connected[next];
                if(connected[next] == 0) queue.add(next);
            }
        }
        if (answer.size() < N) {
            System.out.println(0);
        } else {
            answer.stream().forEach(System.out::println);
        }
    }
}
