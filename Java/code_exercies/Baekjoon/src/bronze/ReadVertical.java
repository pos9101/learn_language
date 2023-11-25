package bronze;

import java.io.*;
import java.util.Arrays;

/**
 * Baekjoon 10798
 * @link https://www.acmicpc.net/problem/10798
 */
public class ReadVertical {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] words = new char[5][15];
        for (char[] word : words) {
            Arrays.fill(word, '!');
        }
        for (int i = 0; i < 5; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                words[i][j] = word.charAt(j);
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                char c = words[j][i];
                if(c == '!') continue;
                bw.write(String.valueOf(c));
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
