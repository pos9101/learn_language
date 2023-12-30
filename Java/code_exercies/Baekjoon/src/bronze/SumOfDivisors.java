package bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Baekjoon 9506
 * @link https://www.acmicpc.net/problem/9506
 */
public class SumOfDivisors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            final int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            int[] divisors = solveDivisors(n);
            int sum = Arrays.stream(divisors).sum();
            if (sum == n) {
                StringJoiner sj = new StringJoiner(" + ");
                Arrays.stream(divisors).forEach(x -> sj.add(String.valueOf(x)));
                bw.write(n + " = " + sj.toString() + "\n");
            } else {
                bw.write(n + " is NOT perfect.\n");
            }
        }
        br.close();
        bw.close();
    }

    private static int[] solveDivisors(int n) {
        return IntStream.range(1, n).filter(x -> n % x == 0).toArray();
    }
}
