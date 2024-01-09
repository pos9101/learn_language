package gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 9466
 * @link https://www.acmicpc.net/problem/9466
 */
public class TermProject {

    static int[] array;
    static boolean[] visited;
    static boolean[] noSearch;
    static int noTeamNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            noTeamNum = n;
            array = new int[n + 1];
            visited = new boolean[n + 1];
            noSearch = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                array[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j <= n; j++) {
                dfs(j);
            }
            bw.write(noTeamNum + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int num) {
        if(noSearch[num]) return;
        if(!visited[num]) {
            visited[num] = true;
            dfs(array[num]);
            noSearch[num] = true;
            return;
        }
        noSearch[num] = true;
        --noTeamNum;
        dfs(array[num]);
    }
}
