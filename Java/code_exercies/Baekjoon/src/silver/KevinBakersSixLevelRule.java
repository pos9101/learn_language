package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 1389
 * @link https://www.acmicpc.net/problem/1389
 */
public class KevinBakersSixLevelRule {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] relationDistance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                relationDistance[i][j] = 100;
            }
        }
        for (int i = 1; i <= N; i++) {
            relationDistance[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            relationDistance[start][end] = 1;
            relationDistance[end][start] = 1;
        }
        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    if(relationDistance[s][e] > relationDistance[s][m] + relationDistance[m][e]) {
                        relationDistance[s][e] = relationDistance[s][m] + relationDistance[m][e];
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int arrayIdx = -1;
        for (int i = 1; i <= N; i++) {
            int kevinBakerNum = Arrays.stream(relationDistance[i]).sum();
            if (kevinBakerNum < min) {
                min = kevinBakerNum;
                arrayIdx = i;
            }
        }

        System.out.println(arrayIdx);
        br.close();
    }
}
