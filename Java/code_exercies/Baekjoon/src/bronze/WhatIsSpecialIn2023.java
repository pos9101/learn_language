package bronze;

import java.io.*;

/**
 * Baekjoon 31090
 * @link https://www.acmicpc.net/submit/31090
 */
public class WhatIsSpecialIn2023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            final int N = Integer.parseInt(br.readLine());
            int divider = N % 100;
            if((N + 1) % divider == 0) {
                bw.write("Good\n");
            } else {
                bw.write("Bye\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
