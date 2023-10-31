package silver;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 15652
 * @link https://www.acmicpc.net/problem/15652
 */
public class NAndM4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] combination = new int[M];
        takeCombination(bw, combination, N, 0, 1, M);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void takeCombination(BufferedWriter bw, int[] combination, final int N, int index, int start, final int M) throws IOException {
        if(index == M) {
            StringJoiner sj = new StringJoiner(" ");
            for (int i : combination) {
                sj.add(String.valueOf(i));
            }
            bw.write(sj.toString() + "\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            combination[index] = i;
            takeCombination(bw, combination, N, index + 1, i, M);
        }
    }
}
