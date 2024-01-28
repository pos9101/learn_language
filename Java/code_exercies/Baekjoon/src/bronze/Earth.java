package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 9063
 * @link https://www.acmicpc.net/problem/9063
 */
public class Earth {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int upperX = -10000;
        int lowerX = 10000;
        int upperY = -10000;
        int lowerY = 10000;

        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x > upperX) upperX = x;
            if(x < lowerX) lowerX = x;
            if(y > upperY) upperY = y;
            if(y < lowerY) lowerY = y;
        }
        System.out.println((upperX - lowerX) * (upperY - lowerY));
        br.close();
    }
}
