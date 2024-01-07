package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 2845
 * @link https://www.acmicpc.net/problem/2845
 */
public class AfterTheParty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringJoiner sj = new StringJoiner(" ");
        final int L = Integer.parseInt(st.nextToken());
        final int P = Integer.parseInt(st.nextToken());
        final int participated = L * P;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 5; i++) {
            sj.add((String.valueOf(Integer.parseInt(st.nextToken()) - participated)));
        }
        System.out.println(sj.toString());
        br.close();
    }
}
