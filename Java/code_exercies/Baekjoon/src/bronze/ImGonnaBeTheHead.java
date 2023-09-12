package bronze;

import java.io.*;

/**
 * Baekjoon 2775
 * @link https://www.acmicpc.net/problem/2775
 */
public class ImGonnaBeTheHead {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int T = Integer.parseInt(br.readLine());
        //[x][y] : Floor x, Room y
        int[][] livingPeopleMemory = new int[15][15];
        for (int i = 0; i < 15; i++) {
            livingPeopleMemory[0][i] = i;
        }
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(takeLivingPeople(livingPeopleMemory, k, n) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static int takeLivingPeople(int[][] memory, int k, int n) {
        if(memory[k][n] != 0) {
            return memory[k][n];
        }
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += takeLivingPeople(memory, k-1, i);
        }
        memory[k][n] = ret;
        return memory[k][n];
    }
}
