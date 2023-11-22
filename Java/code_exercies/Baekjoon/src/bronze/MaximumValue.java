package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 2566
 * @link https://www.acmicpc.net/problem/2566
 */
public class MaximumValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] array = new int[10][10];
        int max = -1;
        int row = 0;
        int col = 0;
        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 9; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (array[i][j] > max) {
                    max = array[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        bw.write(max + "\n");
        bw.write(row + " " + col);
        bw.flush();
        br.close();
        bw.close();
    }
}
