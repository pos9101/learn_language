package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * baekjoon 2563
 * @link https://www.acmicpc.net/problem/2563
 */
public class ColoredPaper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        boolean[][] existed = new boolean[101][101];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    existed[j][k] = true;
                }
            }
        }

        int count = 0;
        for (boolean[] booleans : existed) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}
