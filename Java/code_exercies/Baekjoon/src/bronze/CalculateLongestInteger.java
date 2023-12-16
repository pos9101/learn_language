package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Baekjoon 2338
 * @link https://www.acmicpc.net/problem/2338
 */
public class CalculateLongestInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        br.close();
    }
}
