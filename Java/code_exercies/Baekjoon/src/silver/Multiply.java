package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1629
 * @link https://www.acmicpc.net/problem/1629
 */
public class Multiply {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());
        long temp = A;
        long result = 1;
        while (B > 0) {
            if (B % 2 == 1) result = (result * temp) % C;
            temp = temp * temp % C;
            B /= 2;
        }
        System.out.println(result);

        br.close();
    }
}
