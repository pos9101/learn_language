package bronze;

import java.io.*;

/**
 * Baekjoon 1259
 * @link https://www.acmicpc.net/problem/1259
 */
public class PalindromNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }
            bw.write(isPalindrom(line) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static String isPalindrom(String line) {
        final int LENGTH = line.length();
        final int mid = LENGTH % 2 == 0 ? LENGTH/2 - 1 : LENGTH/2;
        for (int i = 0; i <= mid; i++) {
            if(line.charAt(i) != line.charAt(LENGTH -1 - i)){
                return "no";
            }
        }
        return "yes";
    }
}
