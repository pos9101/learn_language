package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 2562
 * https://www.acmicpc.net/problem/2562
 */
public class Maximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if(max < num) {
                max = num;
                count = i;
            }
        }

        System.out.println(max);
        System.out.println(count);

        br.close();
    }
}
