package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Baekjoon 2587
 * @link https://www.acmicpc.net/problem/2587
 */
public class RepresentativeValue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int[] array = new int[]{a, b, c, d, e};
        Arrays.sort(array);
        System.out.println(Arrays.stream(array).sum() / 5);
        System.out.println(array[2]);
        br.close();
    }
}
