package sprout;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Baekjoon 10951
 * @link https://www.acmicpc.net/problem/10951
 */
public class APlusB4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if(line == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(a + b);
        }

        br.close();

    }
}
