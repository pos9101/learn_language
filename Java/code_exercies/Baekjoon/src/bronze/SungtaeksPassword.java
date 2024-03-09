package bronze;

import java.io.*;

/**
 * Baekjoon 25372
 * @link https://www.acmicpc.net/problem/25372
 */
public class SungtaeksPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.length() <= 9 && line.length() >= 6) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
