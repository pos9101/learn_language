package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 3046
 * @link https://www.acmicpc.net/problem/3046
 */
public class R2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int R1 = Integer.parseInt(st.nextToken());
        final int S = Integer.parseInt(st.nextToken());
        System.out.println(S * 2 - R1);
        br.close();
    }
}
