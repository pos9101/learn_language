package gold;

import java.io.*;

/**
 * Baekjoon 9251
 * @link https://www.acmicpc.net/problem/9251
 */
public class LCS {
    private static String first;
    private static String second;
    private static int[][] lcsArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        first = br.readLine();
        second = br.readLine();
        lcsArray = new int[first.length() + 1][second.length() + 1];
        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                calculateLCS(i, j);
            }
        }
        bw.write(String.valueOf(lcsArray[first.length()][second.length()]));
        bw.flush();
        br.close();
        bw.close();
    }

    private static int calculateLCS(int firstIdx, int secondIdx) {
        if (lcsArray[firstIdx][secondIdx] != 0) {
            return lcsArray[firstIdx][secondIdx];
        }
        if (firstIdx == 0 || secondIdx == 0) {
            return 0;
        }
        if (first.charAt(firstIdx - 1) == second.charAt(secondIdx - 1)) {
            lcsArray[firstIdx][secondIdx] = 1 + lcsArray[firstIdx - 1][secondIdx - 1];
            return lcsArray[firstIdx][secondIdx];
        }
        lcsArray[firstIdx][secondIdx] = Math.max(lcsArray[firstIdx - 1][secondIdx],
                lcsArray[firstIdx][secondIdx - 1]);
        return lcsArray[firstIdx][secondIdx];
    }
}
