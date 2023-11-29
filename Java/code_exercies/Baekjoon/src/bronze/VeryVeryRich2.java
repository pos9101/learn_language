package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Baekjoon 1271
 * @link https://www.acmicpc.net/problem/1271
 */
public class VeryVeryRich2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        System.out.println(n.divide(m).toString());
        System.out.println(n.remainder(m).toString());
        br.close();
    }
}
