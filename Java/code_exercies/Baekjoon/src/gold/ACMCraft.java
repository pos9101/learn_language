package gold;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Baekjoon 1005
 * @link https://www.acmicpc.net/problem/1005
 */
public class ACMCraft {

    static int N;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        //Test T times
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            final int K = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[N];
            IntStream.range(0, graph.length).forEach(x -> graph[x] = new ArrayList<>());
            int[] dArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] connected = new int[N];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                final int X = Integer.parseInt(st.nextToken());
                final int Y = Integer.parseInt(st.nextToken());
                graph[takeArrIdx(X)].add(takeArrIdx(Y));
                connected[takeArrIdx(Y)] += 1;
            }
            final int W = Integer.parseInt(br.readLine());
            //business logic
            solveTimeToWin(graph, dArray, connected, takeArrIdx(W));
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void solveTimeToWin(ArrayList<Integer>[] graph, int[] dArray, int[] connected, int exitIdx) throws IOException {
        //zero connected Queue
        int[] buildTime = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(0, N).filter(i -> connected[i] == 0).forEach(queue::add);
        while (!queue.isEmpty()) {
            Integer pollIdx = queue.poll();
            buildTime[pollIdx] += dArray[pollIdx];
            for(int nextIdx : graph[pollIdx]) {
                buildTime[nextIdx] = Math.max(buildTime[nextIdx], buildTime[pollIdx]);
                --connected[nextIdx];
                if(connected[nextIdx] == 0) queue.add(nextIdx);
            }
        }
        bw.write(buildTime[exitIdx] + "\n");
    }

    private static int takeArrIdx(int num) {
        return num - 1;
    }
}
