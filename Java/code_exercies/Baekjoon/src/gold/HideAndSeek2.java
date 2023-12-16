package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 12851
 * @link https://www.acmicpc.net/problem/12851
 */
public class HideAndSeek2 {
    static final int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int[] answer = bfs(N, K);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        br.close();
    }

    private static int[] bfs(int start, int end) {
        int finished = 0;

        int[] visitedTime = new int[200001];
        Arrays.fill(visitedTime, MAX);
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> firstList = new ArrayList<>();
        visitedTime[start] = 0;
        firstList.add(start);
        queue.add(firstList);
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            List<Integer> nextList = new ArrayList<>();
            for (int val : poll) {
                if(val == end) {
                    ++finished;
                    continue;
                }
                int[] moving = new int[]{val - 1, val + 1, val * 2};
                for (int next : moving) {
                    if (canMove(next) && visitedTime[val] + 1 <= visitedTime[next]) {
                        visitedTime[next] = visitedTime[val] + 1;
                        nextList.add(next);
                    }
                }
            }
            if (!nextList.isEmpty()) queue.add(nextList);
        }
        return new int[]{visitedTime[end], finished};
    }

    private static boolean canMove(int next) {
        return next >= 0 && next <= 200000;
    }
}
