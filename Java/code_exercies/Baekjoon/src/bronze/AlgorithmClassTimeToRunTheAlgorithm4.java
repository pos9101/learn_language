package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Baekjoon 24265
 * @link https://www.acmicpc.net/problem/24265
 */
public class AlgorithmClassTimeToRunTheAlgorithm4 {
    static BigInteger answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        answer = new BigInteger("0");
        for (int i = 1; i <= n - 1; i++) {
            answer = answer.add(new BigInteger(String.valueOf(i)));
        }
        System.out.println(answer.toString());
        System.out.println(2);
        br.close();
    }
}
