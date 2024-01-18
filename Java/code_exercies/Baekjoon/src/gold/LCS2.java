package gold;

import java.io.*;

/**
 * Baekjoon 9252
 * @link https://www.acmicpc.net/problem/9252
 */
public class LCS2 {
    static String line;
    static String line2;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        line = br.readLine();
        line2 = br.readLine();
        int[][] memory = new int[line.length() + 1][line2.length() + 1];
        for (int i = 1; i <= line.length(); i++) {
            for (int j = 1; j <= line2.length(); j++) {
                calLCS(memory, i, j);
            }
        }
        bw.write(memory[line.length()][line2.length()] + "\n");
        printLCS(memory, line.length(), line2.length());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void printLCS(int[][] memory, int firstIdx, int secondIdx) throws IOException {
        char[] lcs = new char[memory[line.length()][line2.length()]];
        int lcsIdx = lcs.length - 1;
        while(firstIdx != 0 && secondIdx != 0){
            if(line.charAt(firstIdx - 1) == line2.charAt(secondIdx - 1)) {
                lcs[lcsIdx] = line.charAt(firstIdx - 1);
                --lcsIdx;
                --firstIdx;
                --secondIdx;
                continue;
            }
            if (memory[firstIdx - 1][secondIdx] > memory[firstIdx][secondIdx - 1]) {
                --firstIdx;
            } else {
                --secondIdx;
            }
        }
        for (char c : lcs) {
            bw.write(Character.toString(c));
        }

    }

    private static int calLCS(int[][] memory, int firstIdx, int secondIdx) {
        if(memory[firstIdx][secondIdx] != 0 ) return memory[firstIdx][secondIdx];
        if (firstIdx == 0 || secondIdx == 0) return memory[firstIdx][secondIdx];
        if (line.charAt(firstIdx - 1) == line2.charAt(secondIdx - 1)) {
            memory[firstIdx][secondIdx] = memory[firstIdx - 1][secondIdx - 1] + 1;
            return memory[firstIdx][secondIdx];
        }
        memory[firstIdx][secondIdx] = Math.max(memory[firstIdx - 1][secondIdx], memory[firstIdx][secondIdx - 1]);
        return memory[firstIdx][secondIdx];
    }
}
