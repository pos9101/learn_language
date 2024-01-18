package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1085
 * @link https://www.acmicpc.net/problem/1085
 */
public class ExitFromSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int x = Integer.parseInt(st.nextToken());
        final int y = Integer.parseInt(st.nextToken());
        final int w = Integer.parseInt(st.nextToken());
        final int h = Integer.parseInt(st.nextToken());
        System.out.println(Math.min(Math.min(w - x, x), Math.min(h - y, y)));
        br.close();
    }
}
