package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Baekjoon 24264
 * @link https://www.acmicpc.net/problem/24264
 */
public class AlgorithmClassTimeToRunTheAlgorithm3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BigInteger n = new BigInteger(br.readLine());

        System.out.println(n.multiply(n).toString());
        System.out.println(2);
        br.close();
    }
}
