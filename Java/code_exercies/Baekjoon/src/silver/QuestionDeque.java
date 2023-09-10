package silver;

import java.io.*;
import java.util.LinkedList;

/**
 * Baekjoon 10866
 * @link https://www.acmicpc.net/problem/10866
 */
public class QuestionDeque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> deque = new LinkedList<>();
        final int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            bw.write(actDeque(deque, command));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static String actDeque(LinkedList<Integer> deque, String command) {
        final String NEW_LINE = "\n";
        switch (command) {
            case "pop_front":
                return (deque.isEmpty() ? -1 : deque.removeFirst()) + NEW_LINE;
            case "pop_back":
                return (deque.isEmpty() ? -1 : deque.removeLast()) + NEW_LINE;
            case "size":
                return deque.size() + NEW_LINE;
            case "empty":
                return (deque.isEmpty() ? 1 : 0) + NEW_LINE;
            case "front":
                return (deque.isEmpty() ? -1 : deque.getFirst()) + NEW_LINE;
            case "back":
                return (deque.isEmpty() ? -1 : deque.getLast()) + NEW_LINE;
            default:
                if(command.contains("push_front")){ //push_front X
                    deque.addFirst(Integer.valueOf(command.substring(11)));
                } else { //push_back X
                    deque.addLast(Integer.valueOf(command.substring(10)));
                }
        }
        return "";
    }
}
