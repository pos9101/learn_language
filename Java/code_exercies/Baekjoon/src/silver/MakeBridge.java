package silver;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 1010
 * @link https://www.acmicpc.net/problem/1010
 */
public class MakeBridge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        int[][] memory = new int[30][30];
        for (int i = 0; i < 30; i++) {
            //(n) , (n)
            //(n)   (0)
            memory[i][i] = 1;
            memory[i][0] = 1;
        }
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            bw.write(solveCombination(memory, m, n) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    // inclusion-exclusion principle
    // ( n     )    =  ( n - 1 )    +   ( n - 1 )
    // ( r     )       ( r     )    +   ( r - 1 )
    private static int solveCombination(int[][] memory, int n, int r) {
        if (memory[n][r] != 0) {
            return memory[n][r];
        }
        memory[n][r] = solveCombination(memory, n - 1, r) + solveCombination(memory, n - 1, r - 1);
        return memory[n][r];
    }
}
