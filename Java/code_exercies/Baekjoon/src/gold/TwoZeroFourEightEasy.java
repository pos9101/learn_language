package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 12100
 * @link https://www.acmicpc.net/problem/12100
 */
public class TwoZeroFourEightEasy {
    static int max = 0;
    static int N;
    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;
    static int[] moving = {UP, DOWN, LEFT, RIGHT};
    static int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        moveCount(map, 0);
        System.out.println(max);
        br.close();
    }

    private static void moveCount(int[][] map, int count) {
        if(count == 5) {
            max = Math.max(max, Arrays.stream(map).flatMapToInt(Arrays::stream).max().orElse(0));
            return;
        }
        for (int direction : moving) {
            //copyArray
            int[][] clone = clone2DArray(map);
            moveDirection(map, direction);
            moveCount(map, count + 1);
            //rollback
            map = clone;
        }
    }

    private static void moveDirection(int[][] map, int direction) {
        boolean[][] isMerged = new boolean[N][N];
        switch (direction) {
            case UP:
                for (int col = 0; col < N; col++) {
                    for (int row = 0; row < N; row++) {
                        moveCell(map, row, col, isMerged, UP);
                    }
                }
                break;
            case DOWN:
                for (int col = 0; col < N; col++) {
                    for (int row = N - 1; row >= 0; row--) {
                        moveCell(map, row, col, isMerged, DOWN);
                    }
                }
                break;
            case LEFT:
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        moveCell(map, row, col, isMerged, LEFT);
                    }
                }
                break;
            case RIGHT:
            default:
                for (int row = 0; row < N; row++) {
                    for (int col = N - 1; col >= 0; col--) {
                        moveCell(map, row, col, isMerged, RIGHT);
                    }
                }
                break;
        }
    }

    private static void moveCell(int[][] map, final int row, final int col, boolean[][] isMerged, final int location) {
        if(map[row][col] == 0) return;
        //{row, col}
        int[] position = findPosition(map, isMerged, row, col, location);
        //Can't move
        if(row == position[0] && col == position[1]) return;
        //Move
        map[position[0]][position[1]] += map[row][col];
        map[row][col] = 0;
    }

    //return merge position it can merge but also return moving position.
    private static int[] findPosition(int[][] map, boolean[][] isMerged,
                                      final int row, final int col, final int location) {
        int[] position = new int[2];

        int x = row;
        int y = col;
        while(true) {
            int tempRow = x + step[location][0];
            int tempCol = y + step[location][1];
            if(!canMove(tempRow, tempCol) || (map[tempRow][tempCol] != 0 && map[tempRow][tempCol] != map[row][col])) {
                position[0] = x;
                position[1] = y;
                break;
            }
            if(map[tempRow][tempCol] == 0) {
                //Do Nothing
            } else if(map[tempRow][tempCol] == map[row][col]) {
                if(isMerged[tempRow][tempCol]) {
                    position[0] = x;
                    position[1] = y;
                    break;
                }
                isMerged[tempRow][tempCol] = true;
            }
            x = tempRow;
            y = tempCol;
        }
        return position;
    }

    private static boolean canMove(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static int[][] clone2DArray(int[][] map) {
        int[][] cloneMap = new int[N][N];
        for (int i = 0; i < map.length; i++) cloneMap[i] = map[i].clone();
        return cloneMap;
    }
}
