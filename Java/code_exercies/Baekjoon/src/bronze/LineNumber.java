package bronze;

import java.io.*;

/**
 * Baekjoon 4470
 * @link https://www.acmicpc.net/problem/4470
 */
public class LineNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            bw.write(i + ". "+ br.readLine() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
