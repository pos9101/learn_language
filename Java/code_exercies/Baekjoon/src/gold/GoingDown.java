package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 2096
 * @link https://www.acmicpc.net/problem/2096
 */
public class GoingDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N][3];
        int[][] maxVal = new int[N][3];
        int[][] minVal = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            dp(map, maxVal, minVal, i);
        }

        System.out.println(Arrays.stream(maxVal[N - 1]).max().orElse(0) + " " + Arrays.stream(minVal[N - 1]).min().orElse(0));
        br.close();
    }

    private static void dp(int[][] map, int[][] maxVal, int[][] minVal, int rowIndex) {
        if(Arrays.stream(maxVal[rowIndex]).max().orElse(0) > 0 || Arrays.stream(minVal[rowIndex]).min().orElse(0) > 0) {
            return;
        }
        if(rowIndex == 0) {
            for (int i = 0; i < 3; i++) {
                maxVal[0][i] = map[0][i];
                minVal[0][i] = map[0][i];
            }
            return;
        }
        maxVal[rowIndex][0] = Math.max(maxVal[rowIndex - 1][0], maxVal[rowIndex - 1][1]) + map[rowIndex][0];
        maxVal[rowIndex][1] = Arrays.stream(maxVal[rowIndex - 1]).max().orElse(0) + map[rowIndex][1];
        maxVal[rowIndex][2] = Math.max(maxVal[rowIndex - 1][1], maxVal[rowIndex - 1][2]) + map[rowIndex][2];

        minVal[rowIndex][0] = Math.min(minVal[rowIndex - 1][0], minVal[rowIndex - 1][1]) + map[rowIndex][0];
        minVal[rowIndex][1] = Arrays.stream(minVal[rowIndex - 1]).min().orElse(0) + map[rowIndex][1];
        minVal[rowIndex][2] = Math.min(minVal[rowIndex - 1][1], minVal[rowIndex - 1][2]) + map[rowIndex][2];
    }
}
