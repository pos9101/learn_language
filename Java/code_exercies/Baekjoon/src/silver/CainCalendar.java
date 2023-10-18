package silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 6064
 * @link https://www.acmicpc.net/problem/6064
 */
public class CainCalendar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            final int M = Integer.parseInt(st.nextToken());
            final int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lcm = lcm(M, N);

            int num = x;
            boolean existAnswer = false;
            while (num <= lcm) {
                int yVal = num % N;
                if(yVal == y || ((y == N) && (yVal == 0)) ) {
                    existAnswer = true;
                    bw.write(num + "\n");
                    break;
                }
                num += M;
            }
            if (!existAnswer) {
                bw.write("-1\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }

    private static int gcd(int m, int n) {
        if(n == 0) return m;
        return gcd(n, m % n);
    }
}
