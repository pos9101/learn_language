package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 9663
 * @link https://www.acmicpc.net/problem/9663
 */
public class NQueen {

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] rows = new int[N];
        solveNQueens(rows, 0);
        System.out.println(count);
        br.close();
    }

    private static void solveNQueens(int[] rows, int row) {
        if(row == rows.length){
            ++count;
            return;
        }
        for (int i = 0; i < rows.length; i++) {
            if(isPossible(rows, row, i)) {
                rows[row] = i;
                solveNQueens(rows, row + 1);
            }
        }

    }

    private static boolean isPossible(int[] rows, int row, int col) {
        for (int j = 0; j < row; j++) {
            if(rows[j] == col || col - rows[j] == row - j || rows[j] - col == row - j) return false;
        }
        return true;
    }
}
