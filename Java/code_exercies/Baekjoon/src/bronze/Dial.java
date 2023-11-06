package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 5622
 * @link https://www.acmicpc.net/problem/5622
 */
public class Dial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            sum += charToIntWithDial(line.charAt(i));
        }
        System.out.println(sum);
        br.close();
    }

    private static int charToIntWithDial(char c) {
        switch (c) {
            case 'A': case 'B': case 'C':
                return 3;
            case 'D': case 'E': case 'F':
                return 4;
            case 'G': case 'H': case 'I':
                return 5;
            case 'J': case 'K': case 'L':
                return 6;
            case 'M': case 'N': case 'O':
                return 7;
            case 'P': case 'Q': case 'R': case 'S':
                return 8;
            case 'T': case 'U': case 'V':
                return 9;
            case 'W': case 'X': case 'Y': case 'Z':
            default :
                return 10;
        }
    }
}
