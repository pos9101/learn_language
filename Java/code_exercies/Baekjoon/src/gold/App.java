package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 7579
 * @link https://www.acmicpc.net/problem/7579
 */
public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[] appMemory = new int[N + 1];
        int[] appExitCost = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            appMemory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            appExitCost[i] = Integer.parseInt(st.nextToken());
        }

        //row : app, col: cost
        int[][] dp = new int[N + 1][10001];
        for (int app = 1; app <= N; app++) {
            for (int cost = 0; cost <= 10000; cost++) {
                int memoryWithApp = cost >= appExitCost[app] ? appMemory[app] + dp[app - 1][cost - appExitCost[app]] : 0;
                int memoryWithoutApp = dp[app - 1][cost];
                dp[app][cost] = Math.max(dp[app][cost], Math.max(memoryWithApp, memoryWithoutApp));
            }
        }
        boolean isAnswer = false;
        for (int i = 0; i <= 10000; i++) {
            if(dp[N][i] >= M) {
                isAnswer = true;
                System.out.println(i);
                break;
            }
        }
        br.close();
    }
}
