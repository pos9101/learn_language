package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Baekjoon 24267
 * @link https://www.acmicpc.net/problem/24267
 */
public class AlgorithmClassTimeToRunTheAlgorithm6 {
    static BigInteger answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger nMinus1 = n.subtract(new BigInteger("1"));
        BigInteger nMinus2 = n.subtract(new BigInteger("2"));
        BigInteger answer;

        answer = nMinus2.multiply(nMinus1).multiply(n).divide(new BigInteger("6"));
        System.out.println(answer.toString());
        System.out.println(3);
        br.close();
    }
}
