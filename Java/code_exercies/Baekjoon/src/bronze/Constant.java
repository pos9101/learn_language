package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2908
 * @link https://www.acmicpc.net/problem/2908
 */
public class Constant {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();
        StringBuilder reverseA = new StringBuilder();
        StringBuilder reverseB = new StringBuilder();
        for (int i = A.length() - 1; i >= 0; i--) {
            reverseA.append(A.charAt(i));
        }
        for (int i = B.length() - 1; i >= 0; i--) {
            reverseB.append(B.charAt(i));
        }
        int reverseConstantA = Integer.parseInt(reverseA.toString());
        int reverseConstantB = Integer.parseInt(reverseB.toString());

        System.out.println(Math.max(reverseConstantA, reverseConstantB));

        br.close();
    }
}
