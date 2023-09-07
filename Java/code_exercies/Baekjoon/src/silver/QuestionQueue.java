package silver;

import java.io.*;
import java.util.LinkedList;

/**
 * Baekjoon 10845
 * @link https://www.acmicpc.net/problem/10845
 */
public class QuestionQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            bw.write(actQueue(queue, line));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static String actQueue(LinkedList<Integer> queue, String line) {
        // push, pop, size, empty, front, back
        final String NEW_LINE = "\n";
        String result;
        switch (line) {
            case "pop":
                if(queue.isEmpty()) {
                    return "-1" + NEW_LINE;
                }
                result = queue.getFirst() + NEW_LINE;
                queue.removeFirst();
                return result;
            case "size":
                return queue.size() + NEW_LINE;
            case "empty":
                return (queue.isEmpty() ? 1 : 0) + NEW_LINE;
            case "front":
                return (queue.isEmpty() ? -1 : queue.getFirst()) + NEW_LINE;
            case "back":
                return (queue.isEmpty() ? -1 : queue.getLast()) + NEW_LINE;
            default: //push
                queue.addLast(Integer.parseInt(line.substring(5)));
                return "";
        }
    }
}
