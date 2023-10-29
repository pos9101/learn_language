package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 20499
 * @link https://www.acmicpc.net/problem/20499
 */
public class DariusNotHanta {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        final int K = Integer.parseInt(st.nextToken());
        final int D = Integer.parseInt(st.nextToken());
        final int A = Integer.parseInt(st.nextToken());

        if(K + A < D || D == 0) {
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }
    }
}
