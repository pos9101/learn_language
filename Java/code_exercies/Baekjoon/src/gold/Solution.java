package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2467
 * @link https://www.acmicpc.net/problem/2467
 */
public class Solution {
    static int abs = 2000000000;
    static int lower;
    static int upper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int x = 0;
        int y = N - 1;
        while(x < N) {
            while(y > x) {
                int sum = array[x] + array[y];
                if(Math.abs(sum) < abs) {
                    abs = Math.abs(sum);
                    lower = array[x];
                    upper = array[y];
                }
                if(sum < 0) {
                    break;
                }
                --y;
            }
            ++x;
        }
        System.out.println(lower + " " + upper);
        br.close();
    }
}
