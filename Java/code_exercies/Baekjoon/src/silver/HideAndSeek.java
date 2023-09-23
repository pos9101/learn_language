package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 1697
 * @link https://www.acmicpc.net/problem/1697
 */
public class HideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        System.out.println(solveSecond(N, K));
        br.close();
    }

    private static int solveSecond(int n, int k) {
        if (n == k) {
            return 0;
        }
        int[] secondMemory = new int[100001];
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> first = new ArrayList<>();
        first.add(n);
        queue.offer(first);
        secondMemory[n] = 1; //for visit History
        int second = 0;
        while (!queue.isEmpty()) {
            List<Integer> poll = queue.poll();
            List<Integer> next = new ArrayList<>();
            ++second;
            for (Integer nowP : poll) {
                int[] nextPosition = {nowP - 1, nowP + 1, nowP * 2};
                for (int nextP : nextPosition) {
                    if(nextP == k) {
                        return second;
                    }
                    if(canMove(nextP) && secondMemory[nextP] == 0) {
                        secondMemory[nextP] = second;
                        next.add(nextP);
                    }
                }
            }
            if(!next.isEmpty()) {
                queue.offer(next);
            }
        }
        return second;
    }

    private static boolean canMove(int nextP) {
        return nextP >= 0 && nextP <= 100000;
    }
}
