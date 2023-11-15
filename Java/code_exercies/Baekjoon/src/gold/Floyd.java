package gold;

import java.io.*;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 11404
 * @link https://www.acmicpc.net/problem/11404
 */
public class Floyd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int MAX = 10000000;
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        int[][] prices = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                if(i != j) prices[i][j] = MAX;
            }
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            if(price < prices[start][end]) {
                prices[start][end] = price;
            }
        }
        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if(prices[s][e] > prices[s][m] + prices[m][e]) {
                        prices[s][e] = prices[s][m] + prices[m][e];
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            StringJoiner sj = new StringJoiner(" ");
            for (int j = 1; j <= N; j++) {
                sj.add(String.valueOf(prices[i][j] != MAX ? prices[i][j] : 0));
            }
            bw.write(sj.toString() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
