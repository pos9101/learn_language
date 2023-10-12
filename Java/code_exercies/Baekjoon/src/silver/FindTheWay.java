package silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 11403
 * @link https://www.acmicpc.net/problem/11403
 */
public class FindTheWay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int m = 0; m < N; m++) {
            for (int s = 0; s < N; s++) {
                for (int e = 0; e < N; e++) {
                    if(array[s][m] == 1 && array[m][e] == 1) {
                        array[s][e] = 1;
                    }
                }
            }
        }
        for (int[] ints : array) {
            for (int anInt : ints) {
                bw.write(anInt + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
