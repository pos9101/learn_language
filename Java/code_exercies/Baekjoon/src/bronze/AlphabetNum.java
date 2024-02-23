package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.UnexpectedException;
import java.util.StringJoiner;

/**
 * Baekjoon 10808
 * @link https://www.acmicpc.net/problem/10808
 */
public class AlphabetNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] alphabetNum = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c >= 'a' && c <= 'z') {
                ++alphabetNum[c - 'a'];
            } else {
                throw new UnexpectedException("Not Supported");
            }
        }
        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < alphabetNum.length; i++) {
            sj.add(String.valueOf(alphabetNum[i]));
        }
        System.out.println(sj.toString());
        br.close();
    }
}
