package sprout;

import java.io.*;

/**
 * Baekjoon 11718
 * @link https://www.acmicpc.net/problem/11718
 */
public class JustPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            bw.write(line + "\n");
        }

        bw.flush();

        br.close();
        bw.close();
    }
}
