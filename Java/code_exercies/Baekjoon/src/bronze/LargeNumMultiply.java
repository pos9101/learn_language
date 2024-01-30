package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Baekjoon 13277
 * @link https://www.acmicpc.net/problem/13277
 */
public class LargeNumMultiply {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final BigInteger A = new BigInteger(st.nextToken());
        final BigInteger B = new BigInteger(st.nextToken());

        System.out.println(A.multiply(B).toString());
        br.close();
    }
}
