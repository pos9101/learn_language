package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 16430
 * @link https://www.acmicpc.net/problem/16430
 */
public class JerryAndTom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int A = Integer.parseInt(st.nextToken());
        final int B = Integer.parseInt(st.nextToken());
        System.out.println(B - A + " " + B);
        br.close();
    }
}
