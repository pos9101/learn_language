package bronze;

import java.io.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Baekjoon 2439
 * @link https://www.acmicpc.net/problem/2439
 */
public class DrawStarTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for(int i = 1; i <= num; i++) {
            int blankNum = num - i;
            int starNum = i;
            StringBuffer sb = new StringBuffer();
            for(int j = 1; j <= blankNum; j++) {
                bw.write(" ");
            }
            for(int k = 1; k <= starNum; k++) {
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
