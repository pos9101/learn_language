package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1152
 * @link https://www.acmicpc.net/problem/1152
 */
public class NumOfWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        while(st.hasMoreTokens()) {
            st.nextToken();
            count++;
        }
        System.out.print(count);
    }
}
