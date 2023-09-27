package silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 14940
 * @link https://www.acmicpc.net/problem/14940
 */
public class EasyShortWay {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int [][] mapArray = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                mapArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solveDistance(mapArray);
        br.close();
    }

    private static void solveDistance(int[][] mapArray) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = mapArray.length;
        final int M = mapArray[0].length;
        int [][] memory = new int[N][M];
        int[] start = findStart(mapArray, N, M);
        int[][] moving = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        LinkedList<int[]> distanceList = new LinkedList<>();
        distanceList.add(start);
        int distanceCount = 0;
        Queue<LinkedList<int[]>> queue = new LinkedList<>();
        queue.add(distanceList);
        while(!queue.isEmpty()) {
            LinkedList<int[]> poll = queue.poll();
            LinkedList<int[]> nextList = new LinkedList<>();
            ++distanceCount;
            for (int[] now : poll) {
                for (int[] step : moving) {
                    int newX = now[0] + step[0];
                    int newY = now[1] + step[1];
                    if(isValidate(newX, newY, N, M)
                            && isMove(mapArray, newX, newY) && memory[newX][newY] == 0){
                        memory[newX][newY] = distanceCount;
                        nextList.add(new int[]{newX, newY});
                    }
                }
            }
            if(!nextList.isEmpty()) {
                queue.add(nextList);
            }
        }

        for (int i = 0; i < N; i++) {
            StringJoiner sj = new StringJoiner(" ");
            for (int j = 0; j < M; j++) {
                int printValue = memory[i][j] != 0 ? memory[i][j] : changeToMinusOne(mapArray, i, j);

                sj.add(String.valueOf(printValue));
            }
            bw.write(sj.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean isValidate(int newX, int newY, int N, int M) {
        return newX >= 0 && newY >= 0 && newX < N && newY < M;
    }

    private static boolean isMove(int[][] mapArray, int newX, int newY) {
        return mapArray[newX][newY] == 1;
    }

    private static int changeToMinusOne(int[][] mapArray, int i, int j) {
        return mapArray[i][j] == 1 ? -1 : 0;
    }

    private static int[] findStart(int[][] mapArray, int N, int M) {
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(mapArray[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        return start;
    }
}
