package sprout;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 10952
 * @link https://www.acmicpc.net/problem/10952
 */
public class APlusBMinusFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) {
                break;
            }

            bw.write(a+b + "\n");
        }




        bw.flush();

        bw.close();
        br.close();
    }
}