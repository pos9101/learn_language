package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Baekjoon 1463
 * @link https://www.acmicpc.net/problem/1463
 */
public class MakeOne {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] data = new int[1000001];
        int num = Integer.parseInt(br.readLine());
        data[2] = 1;
        data[3] = 1;

        System.out.println((num != 1)? f(data, num) : 0);
        br.close();
    }

    /**
     * 1 < n <= 1,000,000 일때만 동작한다.
     */
    public static int f(int[] data, int n) {
        if(data[n] != 0) {
            return data[n];
        }
        List<Integer> values = new ArrayList<>();
        if(n % 3 == 0) {
            values.add(f(data, n / 3));
        }
        if(n % 2 == 0) {
            values.add(f(data, n / 2));
        }
        values.add(f(data, n - 1));

        int min = 1000000;
        for (Integer value : values) {
            if (value < min) {
                min = value;
            }
        }
        data[n] = min + 1;
        return data[n];

    }
}
