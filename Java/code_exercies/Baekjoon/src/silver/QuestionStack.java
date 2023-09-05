package silver;

import java.io.*;
import java.util.LinkedList;


/**
 * Baekjoon 10828
 * @link https://www.acmicpc.net/problem/10828
 */
public class QuestionStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int numOfTestcase = Integer.parseInt(br.readLine());

        LinkedList<Integer> stackList = new LinkedList<>();
        for (int i = 0; i < numOfTestcase; i++) {
            String line = br.readLine();
            String printMessage = doStackCommand(stackList, line);
            if (printMessage != null) {
                bw.write(printMessage);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static String doStackCommand(LinkedList<Integer> stack, String commandLine) {
        final String NEW_LINE = "\n";
        switch(commandLine) {
            case "pop":
                String result;
                if(!stack.isEmpty()) {
                    result = stack.getLast() + NEW_LINE;
                    stack.removeLast();
                    return result;
                }
                result = -1 + NEW_LINE;
                return result;
            case "size":
                return stack.size() + NEW_LINE;
            case "empty":
                return (!stack.isEmpty() ? 0 : 1) + NEW_LINE;
            case "top":
                return (!stack.isEmpty() ? stack.getLast() : -1) + NEW_LINE;
            default : //"push x"
                int value = Integer.parseInt(commandLine.substring(5));
                stack.addLast(value);
                return null;
        }
    }
}
