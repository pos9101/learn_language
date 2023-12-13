package bronze;

import java.io.*;

/**
 * Baekjoon 2720
 * @link https://www.acmicpc.net/problem/2720
 */
public class LaundaryBossDongHyuk {
    static final int QUARTER = 25;
    static final int DIME = 10;
    static final int NICKEL = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int c = Integer.parseInt(br.readLine());
            int qNum = c / QUARTER;
            c %= QUARTER;
            int dNum = c / DIME;
            c %= DIME;
            int nNum = c / NICKEL;
            c %= NICKEL;
            bw.write(qNum + " " + dNum + " " + nNum + " " + c + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
