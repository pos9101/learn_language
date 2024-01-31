package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Baekjoon 2098
 * @link https://www.acmicpc.net/problem/2098
 */
public class TravelingSalesman {
    static int N;
    static int[][] W;
    static int[][] memory;
    static final int MAX = 16000000;
    static final int START_CITY = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        memory = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(START_CITY, 1 << START_CITY));
        br.close();
    }

    private static int dfs(int current, int bitmask) {
        if(memory[current][bitmask] != 0) return memory[current][bitmask];
        if(bitmask == Math.pow(2, N) - 1) return W[current][START_CITY] != 0 ? W[current][START_CITY] : MAX;

        memory[current][bitmask] = MAX;
        //Stream
        IntStream.range(0, N)
                .filter(index -> ((1 << index) & bitmask) == 0 && W[current][index] != 0)
                .forEach(i ->
                        memory[current][bitmask] = Math
                            .min(memory[current][bitmask], dfs(i, bitmask | (1 << i)) + W[current][i])
                );
//        //for grammar
//        for (int i = 0; i < N; i++) {
//            if(((1 << i) & bitmask) == 0 && W[current][i] != 0) {
//                memory[current][bitmask] = Math
//                        .min(memory[current][bitmask], dfs(i, bitmask | (1 << i)) + W[current][i]);
//            }
//        }
        return memory[current][bitmask];
    }
}
