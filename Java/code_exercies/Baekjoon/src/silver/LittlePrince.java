package silver;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * Baekjoon 1004
 * @link https://www.acmicpc.net/problem/1004
 */
public class LittlePrince {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int answerCnt = 0;
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            boolean[][] innerPlanetarySystem = new boolean[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                innerPlanetarySystem[j][0] = isInnerPlanetary(x1, y1, cx, cy, r);
                innerPlanetarySystem[j][1] = isInnerPlanetary(x2, y2, cx, cy, r);
            }
            bw.write(IntStream.range(0, n)
                    .filter(x -> innerPlanetarySystem[x][0] != innerPlanetarySystem[x][1]).count() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isInnerPlanetary(int locationX, int locationY, int planetX, int planetY, int r) {
        return Math.pow(locationX - planetX, 2) + Math.pow(locationY - planetY, 2) < Math.pow(r, 2);
    }
}
