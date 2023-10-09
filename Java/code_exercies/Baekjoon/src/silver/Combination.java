package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Baekjoon 2407
 * @link https://www.acmicpc.net/problem/2407
 */
public class Combination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger[] memory = new BigInteger[n + 1];

        String answer = (n == m)? "1" : factorial(memory, n).divide (factorial(memory, m).multiply(factorial(memory, n - m))).toString();
        System.out.println(answer);
        br.close();
    }

    private static BigInteger factorial(BigInteger[] memory, int n) {
        if(memory[n] != null) {
            return memory[n];
        }
        if(n == 1) {
            memory[1] = new BigInteger("1");
            return memory[1];
        }
        memory[n] = factorial(memory, n - 1).multiply(new BigInteger(String.valueOf(n)));
        return memory[n];
    }
}
