package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 10818
 * @link https://www.acmicpc.net/problem/10818
 */
public class MinAndMax {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int min = 1000000;
        int max = -1000000;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < count; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }

        System.out.println(min + " " + max);

        br.close();
    }
}
