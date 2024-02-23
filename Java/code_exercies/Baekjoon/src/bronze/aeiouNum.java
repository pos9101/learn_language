package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 10987
 * @link https://www.acmicpc.net/problem/10987
 */
public class aeiouNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int answer = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    ++answer;
                    break;
                default:
                    break;
            };
        }
        System.out.println(answer);
        br.close();
    }
}
