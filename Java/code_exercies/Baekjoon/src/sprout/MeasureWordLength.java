package sprout;

import java.io.*;

/**
 * Baekjoon 2743
 * @link https://www.acmicpc.net/problem/2743
 */
public class MeasureWordLength {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        bw.write(String.valueOf(line.length()));

        br.close();
        bw.close();
    }
}
