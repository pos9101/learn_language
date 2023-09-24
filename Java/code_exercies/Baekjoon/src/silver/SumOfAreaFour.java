package silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 11659
 * @link https://www.acmicpc.net/problem/11659
 */
public class SumOfAreaFour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        //not used arr[0]
        int[] arr = new int[N + 1];
        int[] sumMemory = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            bw.write((sumToNum(sumMemory, arr, j) - sumToNum(sumMemory, arr, i-1)) + "\n");
        }
        br.close();
        bw.close();
    }

    private static int sumToNum(int[] sumMemory, int[] arr, int num) {
        if(sumMemory[num] != 0) {
            return sumMemory[num];
        }
        if (num <= 1) {
            sumMemory[num] = arr[num];
            return sumMemory[num];
        }
        sumMemory[num] = arr[num] + sumToNum(sumMemory, arr, num - 1);
        return sumMemory[num];
    }
}
