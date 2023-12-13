package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 1193
 * @link https://www.acmicpc.net/problem/1193
 */
public class FindFraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int X = Integer.parseInt(br.readLine());
        int numerator = 1; //numerator
        int denominator = 1; //denominator
        char operator = '-';
        for (int i = 0; i < X - 1; i++) { //0 to X - 2
            if (operator == '-') {
                if (numerator == 1) {
                    denominator = denominator + 1;
                    operator = '+';
                    continue;
                }
                numerator = numerator - 1;
                denominator = denominator + 1;
            } else { //operator '+'
                if (denominator == 1) {
                    numerator = numerator + 1;
                    operator = '-';
                    continue;
                }
                numerator = numerator + 1;
                denominator = denominator - 1;
            }
        }
        System.out.println(numerator + "/" + denominator);
        br.close();
    }
}
