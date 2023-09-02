package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 11720
 * @link https://www.acmicpc.net/problem/11720
 */
public class SumOfNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String numSeries = br.readLine();
        int sum = 0;
        for (int i = 0; i < numSeries.length(); i++) {
            sum += Character.getNumericValue(numSeries.charAt(i));
        }

        System.out.println(sum);

        br.close();
    }
}
