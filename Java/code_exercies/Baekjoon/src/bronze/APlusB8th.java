package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 11022
 * @link https://www.acmicpc.net/problem/11022
 */
public class APlusB8th {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write("Case #" + i +": "+ a + " + " + b + " = " + (a+b) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
