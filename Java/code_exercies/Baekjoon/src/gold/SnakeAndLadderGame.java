package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 16928
 * @link
 */
public class SnakeAndLadderGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> snakeLadderMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startLadder = Integer.parseInt(st.nextToken());
            int endLadder = Integer.parseInt(st.nextToken());
            snakeLadderMap.put(startLadder, endLadder);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startSnake = Integer.parseInt(st.nextToken());
            int endSnake = Integer.parseInt(st.nextToken());
            snakeLadderMap.put(startSnake, endSnake);
        }
        System.out.println(bfs(snakeLadderMap, 1));
        br.close();
    }

    private static int bfs(Map<Integer, Integer> snakeLadderMap, int start) {
        boolean[] visited = new boolean[101];
        Queue<LinkedList<Integer>> queue = new LinkedList<>();
        LinkedList<Integer> firstList = new LinkedList<>();
        firstList.add(start);
        queue.add(firstList);
        visited[start] = true;
        int diceNum = 0;
        while (!queue.isEmpty()) {
            LinkedList<Integer> poll = queue.poll();
            LinkedList<Integer> nextList = new LinkedList<>();
            for (Integer now : poll) {
                for (int i = 1; i <= 6; i++) {
                    int next = now + i;
                    if (!visited[next]) {
                        if(next == 100) return ++diceNum;
                        visited[next] = true;
                        while(snakeLadderMap.get(next) != null) {
                            next = snakeLadderMap.get(next);
                            visited[next] = true;
                        }
                        nextList.add(next);
                    }
                }
            }
            if(!nextList.isEmpty()) {
                ++diceNum;
                queue.add(nextList);
            }
        }
        return diceNum;
    }
}
