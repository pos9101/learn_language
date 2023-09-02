package sprout;

import java.io.*;

/**
 * Baekjoon 2438
 * @link https://www.acmicpc.net/problem/2438
 */
public class PrintStarOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        for (int i = 1; i <= num; i++) {
            for (int j = i; j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
