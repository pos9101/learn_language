package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 2473
 * @link https://www.acmicpc.net/problem/2473
 */
public class ThreeLiquid {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        System.out.println(solveThreeLiquid(array));
        br.close();
    }

    private static String solveThreeLiquid(int[] array) {
        long sumMin = 3000000001L;
        String answer = null;
        for (int i = 0; i < N - 2; i++) {
            long first = array[i];
            int s = i + 1;
            int e = N - 1;
            while (s < e) {
                long second = array[s];
                long third = array[e];
                long sum = first + second + third;
                if(Math.abs(sum) < Math.abs(sumMin)) {
                    sumMin = sum;
                    answer = first + " " + second + " " + third;
                }
                if (sum > 0) {
                    --e;
                } else if (sum < 0) {
                    ++s;
                } else {
                    return first + " " + second + " " + third;
                }
            }
        }
        return answer;
    }
}
