package gold;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Baekjoon 9019
 * @link https://www.acmicpc.net/problem/9019
 */
public class QuestDSLR {

    private static boolean[] visited = new boolean[10000];
    private static String[] data = new String[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Arrays.fill(visited, false);
            Arrays.fill(data, "");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(bfs(start, end) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static String bfs(int start, int end) {
        String answer = "";
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(!queue.isEmpty()) {
            int nowVal = queue.poll();
            int[] next = {commandD(nowVal), commandS(nowVal), commandL(nowVal), commandR(nowVal)};
            for (int i = 0; i < 4; i++) {
                if(!visited[next[i]]) {
                    data[next[i]] = data[nowVal] + takeCommand(i);
                    visited[next[i]] = true;
                    if (next[i] == end) {
                        return data[next[i]];
                    }
                    queue.add(next[i]);
                }
            }
        }
        return answer;
    }

    private static String takeCommand(int arrayNum) {
        switch (arrayNum) {
            case 0:
                return "D";
            case 1:
                return "S";
            case 2:
                return "L";
            case 3:
            default :
                return "R";
        }
    }

    private static int commandD(int num) {
        return num * 2 % 10000;
    }

    private static int commandS(int num) {
        if(num == 0) return 9999;
        return --num;
    }

    private static int commandL(int num) {
        int val = num / 1000;
        return num * 10 % 10000 + val;
    }

    private static int commandR(int num) {
        int val = num % 10;
        return num / 10 + (val * 1000);
    }
}
