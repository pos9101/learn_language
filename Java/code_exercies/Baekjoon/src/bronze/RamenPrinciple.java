package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 30007
 * @link https://www.acmicpc.net/problem/30007
 */
public class RamenPrinciple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            bw.write(calculateWater(a, b, x) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int calculateWater(int a, int b, int x) {
        return a * (x - 1) + b;
    }
}
