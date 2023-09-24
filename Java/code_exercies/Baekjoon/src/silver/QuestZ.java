package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 1074
 * @link https://www.acmicpc.net/problem/1074
 */
public class QuestZ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int R = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());
        System.out.println(solveZ(N, R, C));
        br.close();
    }

    private static int solveZ(int N, int R, int C) {
        int square = (int) (Math.pow(2, N) * Math.pow(2, N));
        return findMinSquare(R, C, square);
    }

    private static int findMinSquare(int r, int c, int square) {
        if(square == 1) {
            if(r == 1) {
                if(c == 1) {
                    return 3;
                } else {
                    return 2;
                }
            } else {
                if(c == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        int root = (int) Math.sqrt(square);
        if(r >= root || c >= root){
            return findArea(r, c, square);
        }
        return findMinSquare(r, c, square / 4);
    }

    private static int findArea(int r, int c, int square) {
        int root = (int) Math.sqrt(square);
        if(r >= root) {
            if(c >= root) { //4
                return square * 3 + findMinSquare(r - root, c - root, square);
            } else { //3
                return square * 2 + findMinSquare(r - root, c, square);
            }
        } else {
            if(c >= root) { //2
                return square + findMinSquare(r, c - root, square);
            } else { //1
                return findMinSquare(r, c, square);
            }
        }
    }
}
