package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 10817
 * @link https://www.acmicpc.net/problem/10817
 */
public class ThreeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int temp;
        if(array[0] > array[1]) {
            temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
        if(array[1] > array[2]) {
            temp = array[1];
            array[1] = array[2];
            array[2] = temp;
        }
        if(array[0] > array[1]) {
            temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
        System.out.println(array[1]);
        br.close();
    }
}
