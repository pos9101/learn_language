package sprout;

import java.io.*;

/**
 * Baekjoon 2744
 * @link https://www.acmicpc.net/problem/2744
 */
public class ReplaceCase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();
        int len = word.length();
        for(int i = 0; i < len; i++) {
            char spell = word.charAt(i);
            if(spell >= 'a' && spell <= 'z') {
                bw.write((char)(spell - 32));
            }else if(spell >= 'A' && spell <= 'Z') {
                bw.write((char)(spell + 32));
            } else {
                throw new IOException();
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
