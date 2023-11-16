package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Baekjoon 13549
 * @link https://www.acmicpc.net/problem/13549
 */
public class HideAndSeek3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        final int MAX = 200000;
        int[] times = new int[200001];
        Arrays.fill(times, MAX);
        times[N] = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(N);
        while (!deque.isEmpty()) {
            Integer location = deque.pollFirst();
            if (location == K) {
                break;
            }
            int case1 = location * 2;
            if (case1 <= MAX && times[case1] > times[location]) {
                times[case1] = times[location];
                deque.addFirst(case1);
            }
            int case2 = location + 1;
            if (case2 <= MAX && times[case2] > times[location] + 1) {
                times[case2] = times[location] + 1;
                deque.addLast(case2);
            }
            int case3 = location - 1;
            if (case3 >= 0 && times[case3] > times[location] + 1) {
                times[case3] = times[location] + 1;
                deque.addLast(case3);
            }
        }
        System.out.println(times[K]);
        br.close();
    }
}
