package bronze;

import java.io.*;

/**
 * Baekjoon 5524
 * @link https://www.acmicpc.net/problem/5524
 */
public class AdmissionManagement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            bw.write(line.toLowerCase() + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
