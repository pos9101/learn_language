package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 2667
 * @link https://www.acmicpc.net/problem/2667
 */
public class NamingArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[][] area = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            int rowSize = row.length();
            for (int j = 0; j < rowSize; j++) {
                area[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }
        solveNamingSearch(area);
        br.close();
    }

    private static void solveNamingSearch(int[][] area) {
        final int N = area.length;
        boolean[][] isVisited = new boolean[N][N];
        //key: areaNum value: size
        HashMap<Integer, Integer> areaNumMap = new HashMap<>();

        int areaNum = 0;
        //visit whole area
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if(isVisited[x][y])  {
                    continue;
                }
                if (area[x][y] == 0) {
                    continue;
                }
                areaNumMap.put(++areaNum, bfs(area, isVisited, x, y));
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append(areaNumMap.size()).append("\n");
        areaNumMap.values().stream().sorted().forEach(x -> sb.append(x).append("\n"));
        System.out.println(sb.toString());
    }

    /** return size */
    private static int bfs(int[][] area, boolean[][] isVisited, int x, int y) {
        //x, y
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> moving = new LinkedList<>();
        moving.add(new int[]{-1, 0});
        moving.add(new int[]{0, -1});
        moving.add(new int[]{1, 0});
        moving.add(new int[]{0, 1});

        int count = 0;
        isVisited[x][y] = true;
        queue.offer(new int[]{x,y});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            count++;
            int nowX = poll[0];
            int nowY = poll[1];
            for (int[] step : moving) {
                int stepX = nowX + step[0];
                int stepY = nowY + step[1];
                if (canMove(area, stepX, stepY) && area[stepX][stepY] == 1 && !isVisited[stepX][stepY]) {
                    isVisited[stepX][stepY] = true;
                    queue.offer(new int[]{stepX, stepY});
                }
            }
        }
        return count;
    }

    private static boolean canMove(int[][] area, int x, int y) {
        int sizeX = area.length;
        int sizeY = area[0].length;
        return x >= 0 && y >= 0 && x < sizeX && y < sizeY;
    }

}
