package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 16953
 * @link https://www.acmicpc.net/problem/16953
 */
public class ATransferB {
    static final long MAX = 1000000000;
    static int b;
    static boolean isOver = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
         b = Integer.parseInt(st.nextToken());
        System.out.println(bfs(a));
        br.close();
    }

    private static int bfs(int start) {
        int answer = -1;
        Queue<Data> queue = new LinkedList<>();
        queue.offer(new Data(start, 1));
        while (!queue.isEmpty()) {
            Data poll = queue.poll();
            if(poll.num > MAX || poll.num > b) continue;
            if (poll.num == b) {
                answer = poll.count;
                break;
            }
            queue.add(new Data(poll.num * 2, poll.count + 1));
            queue.add(new Data(poll.num * 10 + 1, poll.count + 1));
        }
        return answer;
    }

    static class Data {
        long num;
        int count;

        public Data(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
