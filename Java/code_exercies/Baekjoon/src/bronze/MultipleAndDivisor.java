package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 5086
 * @link https://www.acmicpc.net/problem/5086
 */
public class MultipleAndDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            final int A = Integer.parseInt(st.nextToken());
            final int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) break;
            System.out.println(findRelationShipBetweenAandB(A, B));
        }
        br.close();
    }

    private static String findRelationShipBetweenAandB(final int A, final int B) {
        if (B % A == 0) {
            return "factor";
        }
        if (A % B == 0) {
            return "multiple";
        }
        return "neither";
    }
}
