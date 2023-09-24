package bronze;

import java.io.*;

/**
 * Baekjoon 23808
 * @link https://www.acmicpc.net/problem/23808
 */
public class WriteAt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        String[] lines = new String[]{"@   @", "@   @", "@@@@@", "@   @", "@@@@@"};
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            for (int l = 0; l < N; l++) {
                for (int j = 0; j < line.length(); j++) {
                    for (int k = 0; k < N; k++) {
                        bw.write(Character.toString(line.charAt(j)));
                    }
                }
                bw.write("\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
