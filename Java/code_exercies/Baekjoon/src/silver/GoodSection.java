package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 1059
 * @link https://www.acmicpc.net/problem/1059
 */
public class GoodSection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int S = Integer.parseInt(br.readLine());
        int[] array = new int[S];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < S; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        final int x = Integer.parseInt(br.readLine());
        int min = 1;
        int max = array[S - 1];
        for (int i : array) {
            if(i < x) min = i + 1;
            if(i > x) {
                max = i - 1;
                break;
            }
        }
        int answer = 0;
        if(Arrays.stream(array).filter(val -> val == x).findAny().isPresent()) {
            //Do nothing.
        } else {
            //[x ~ ?] 의 개수
            int upper = max - x;
            //[10보다 작으면서 x를 포함하는 개수]
            int lower = (max - x + 1) * (x - min);
            answer = upper + lower;
        }
        System.out.println(answer);
        br.close();
    }
}
