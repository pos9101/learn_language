package sprout;

import java.io.*;

/**
 * Baekjoon 9086
 * @link https://www.acmicpc.net/problem/9086
 */
public class QuestString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestcase; i++) {
            String line = br.readLine();
            bw.write(line.charAt(0) + "" + line.charAt(line.length() -1) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
