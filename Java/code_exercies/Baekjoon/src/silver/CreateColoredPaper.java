package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 2630
 * @link https://www.acmicpc.net/problem/2630
 */
public class CreateColoredPaper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solveColoredPaper(array);
        br.close();
    }

    private static void solveColoredPaper(int[][] array) {
        int n = array.length;
        int[] solveValues = takeWhiteAndBlue(array, 0, 0, n);
        if(solveValues[0] == 4 && solveValues[1] == 0) {
            System.out.println(1);
            System.out.println(0);
        } else if(solveValues[0] == 0 && solveValues[1] == 4){
            System.out.println(0);
            System.out.println(1);
        } else {
            System.out.println(solveValues[0]);
            System.out.println(solveValues[1]);
        }
    }

    private static int[] takeWhiteAndBlue(int[][] array, int r, int c, int length) {
        if(length == 1) {
            if(array[r][c] == 0) {
                return new int[]{1, 0};
            } else {
                return new int[]{0, 1};
            }
        }
        int whiteNum = 0;
        int blueNum = 0;
        int nextN = length / 2;
        int[][] areas = new int[][]{takeWhiteAndBlue(array, r, c, nextN), takeWhiteAndBlue(array, r + nextN, c, nextN),
                takeWhiteAndBlue(array, r, c + nextN, nextN), takeWhiteAndBlue(array, r + nextN, c + nextN, nextN)};
        for (int[] area : areas) {
            whiteNum += area[0];
            blueNum += area[1];
        }
        if (whiteNum == 4 && blueNum == 0) {
            return new int[]{1, 0};
        } else if (whiteNum == 0 && blueNum == 4) {
            return new int[]{0, 1};
        } else {
            return new int[]{whiteNum, blueNum};
        }
    }
}
