package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Baekjoon 1252
 * @link https://www.acmicpc.net/problem/1252
 */
public class AddBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger a = new BigInteger(st.nextToken(), 2);
        BigInteger b = new BigInteger(st.nextToken(), 2);
        System.out.println(a.add(b).toString(2));
        br.close();
    }
}
