package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 1149
 * @link https://www.acmicpc.net/problem/1149
 */
public class RGBDistance {

    private static int[][] minValue;
    private final static int R = 0;
    private final static int G = 1;
    private final static int B = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        minValue = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int valueR = Integer.parseInt(st.nextToken());
            int valueG = Integer.parseInt(st.nextToken());
            int valueB = Integer.parseInt(st.nextToken());
            minValue[i][R] = calculateValue(valueR, i, R);
            minValue[i][G] = calculateValue(valueG, i, G);
            minValue[i][B] = calculateValue(valueB, i, B);
        }
        System.out.println(Arrays.stream(minValue[N -1]).min().getAsInt());
        br.close();
    }

    private static int calculateValue(int value, int i, int color) {
        if (minValue[i][color] != 0) {
            return minValue[i][color];
        }
        if(i == 0) {
            minValue[i][color] = value;
            return minValue[i][color];
        }
        minValue[i][color] = value + Math.min(minValue[i - 1][(color + 1) % 3], minValue[i - 1][(color + 2) % 3]);
        return minValue[i][color];
    }
}
