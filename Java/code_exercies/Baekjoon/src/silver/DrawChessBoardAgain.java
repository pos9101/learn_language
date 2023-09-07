package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1018
 * @link https://www.acmicpc.net/problem/1018
 */
public class DrawChessBoardAgain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        String[] colorArray = new String[N];
        for (int i = 0; i < N; i++) {
            colorArray[i] = br.readLine();
        }

        int min = 64;
        int max = 0;
        for(int i =0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                final int FIXED_NUM = calculateFixNumInEightByEight(colorArray, i, j);
                if(FIXED_NUM > max) max = FIXED_NUM;
                if(FIXED_NUM < min) min = FIXED_NUM;
            }
        }
        System.out.println(Math.min(Math.min(min, 64 - min) ,Math.min(max, 64 - max)));
        br.close();
    }

    private static int calculateFixNumInEightByEight(String[] colorArray, final int X_START, final int Y_START) {
        int result = 0;
        for(int x = X_START; x < X_START + 8; x++) {
            for (int y = Y_START; y < Y_START + 8; y++) {
                char c = colorArray[x].charAt(y);
                if((x + y) % 2 == 0) {
                    if(c == 'B') result++;
                } else {
                    if(c == 'W') result++;
                }
            }
        }
        return result;
    }
}


