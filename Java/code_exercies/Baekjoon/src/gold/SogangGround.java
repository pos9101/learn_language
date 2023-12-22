package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 14938
 * @link https://www.acmicpc.net/problem/14938
 */
public class SogangGround {
    static final int MAX = 150000;
    static int n;
    static final int SEARCH_AREA = 15;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] ways = new int[n + 1][n + 1];
        int[] items = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(ways[i], MAX);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i == j) ways[i][j] = 0;
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            ways[a][b] = l;
            ways[b][a] = l;
        }
        floydWashall(ways);
        int max = 0;
        for (int[] way : ways) {
            int temp = 0;
            for (int i = 1; i <= n; i++) {
                if (way[i] <= m) temp += items[i];

            }
            if (temp > max) max = temp;
        }
        System.out.println(max);
        br.close();
    }

    private static void floydWashall(int[][] ways) {
        for (int m = 1; m <= n; m++) {
            for (int s = 0; s <= n; s++) {
                for (int e = 0; e <= n ; e++) {
                    if (ways[s][e] > ways[s][m] + ways[m][e]) {
                        ways[s][e] = ways[s][m] + ways[m][e];
                    }
                }
            }
        }
    }
}
