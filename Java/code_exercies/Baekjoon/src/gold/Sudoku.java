package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Baekjoon 2239
 * @link https://www.acmicpc.net/problem/2239
 */
public class Sudoku {
    static boolean isFinished = false;
    static int[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        array = new int[9][9];
        ArrayList<int[]> findArray = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                array[i][j] = Character.getNumericValue(line.charAt(j));
                if(array[i][j] == 0) findArray.add(new int[]{i, j});
            }
        }
        solveSudoku(findArray, 0);

        br.close();
    }

    private static void solveSudoku(ArrayList<int[]> findArray, int findIdx) {
        if(isFinished) return;
        if (findIdx == findArray.size()) {
            isFinished = true;
            for (int[] row : array) {
                for (int col : row) {
                    System.out.print(col);
                }
                System.out.println();
            }
            return;
        }
        int[] position = findArray.get(findIdx);
        for (int insertVal = 1; insertVal <= 9; insertVal++) {
            if(isPossible(insertVal, position[0], position[1])) {
                array[position[0]][position[1]] = insertVal;
                solveSudoku(findArray, findIdx + 1);
                array[position[0]][position[1]] = 0;
            }
        }
    }

    private static boolean isPossible(int insertVal, int row, int col) {
        //row
        if(IntStream.range(0, 9).filter(i -> array[row][i] == insertVal).findAny().isPresent()) return false;
        //col
        if(IntStream.range(0, 9).filter(i -> array[i][col] == insertVal).findAny().isPresent()) return false;
        //3 by 3
        int x = row / 3 * 3;
        int y = col / 3 * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if(array[i][j] == insertVal) return false;
            }
        }
        return true;
    }
}
