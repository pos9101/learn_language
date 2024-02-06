package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 4299
 * @link https://www.acmicpc.net/problem/4299
 */
public class AFCWimbledon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sum = Integer.parseInt(st.nextToken());
        int difference = Integer.parseInt(st.nextToken());
        int doubleLargeScore = sum - difference;
        if(doubleLargeScore % 2 != 0 || difference > sum) {
            System.out.println(-1);
        } else {
            System.out.println((sum - (doubleLargeScore / 2)) + " " + doubleLargeScore / 2);
        }
        br.close();
    }
}
