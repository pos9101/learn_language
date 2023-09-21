package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Baekjoon 2579
 * @link https://www.acmicpc.net/problem/2579
 */
public class ClimbingStairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int numOfStairs = Integer.parseInt(br.readLine());
        int[] stepOfScores = new int[numOfStairs];
        for (int i = 0; i < numOfStairs; i++) {
            stepOfScores[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solveMaximumScore(stepOfScores));
        br.close();
    }

    private static int solveMaximumScore(int[] stepOfScores) {
        int n = stepOfScores.length;
        int[] memory = new int[n];
        if (n > 0) {
            memory[0] = stepOfScores[0];
        }
        if (n > 1){
            memory[1] = memory[0] + stepOfScores[1];
        }
        if (n > 2) {
            memory[2] = Math.max(memory[0] + stepOfScores[2], stepOfScores[1] + stepOfScores[2]);
        }
        return findMaxScore(memory, stepOfScores, stepOfScores.length - 1);
    }

    // 1 -> 1
    // 2 -> 12
    // 3 -> 13 23
    // 4 -> 124 134
    // 5 -> 1245 135 235
    // 6 -> 1356 2356 1246 1346
    // 7 -> 12467 13467 12457 1357 2357
    // .......
    private static int findMaxScore(int[] memory, int[] stepOfScores, int n) {
        if(memory[n] != 0) {
            return memory[n];
        }
        memory[n] = Math.max(findMaxScore(memory, stepOfScores, n - 2) + stepOfScores[n],
                findMaxScore(memory, stepOfScores, n - 3) + stepOfScores[n] + stepOfScores[n - 1]);
        return memory[n];
    }

}
