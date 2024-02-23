package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Baekjoon 24266
 * @link https://www.acmicpc.net/problem/24266
 */
public class AlgorithmClassTimeToRunTheAlgorithm5 {
    static BigInteger answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger answer;
        answer = n.multiply(n).multiply(n);

        System.out.println(answer.toString());
        System.out.println(3);
        br.close();
    }
}
