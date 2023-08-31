package bronze;

import java.io.*;

/**
 * Baekjoon 1032
 * @link https://www.acmicpc.net/problem/1032
 */
public class CommandLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        String[] words = new String[num];
        for(int i = 0; i < num; i++) {
            words[i] = br.readLine();
        }

        String firstWord = words[0];
        for(int i = 0; i < firstWord.length(); i++) {
            char spell = firstWord.charAt(i);
            char compareSpell = spell;

            for(int j =1; j < words.length; j++) {
                compareSpell = words[j].charAt(i);
                if(spell != compareSpell){
                    break;
                }
            }
            if(spell != compareSpell) {
                bw.write("?");
            } else {
                bw.write(Character.toString(spell));
            }
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
