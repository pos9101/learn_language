package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 13866
 * @link https://www.acmicpc.net/problem/13866
 */
public class DivideTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());
        System.out.println(Math.abs(D + A - (B + C)));
        br.close();
    }
}
