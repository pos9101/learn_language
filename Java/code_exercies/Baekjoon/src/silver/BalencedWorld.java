package silver;

import java.io.*;
import java.util.Stack;

/**
 * Baekjoon 4949
 * @link https://www.acmicpc.net/problem/4949
 */
public class BalencedWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            bw.write(isBalcenced(line));
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static String isBalcenced(String line) {
        final String YES = "yes\n";
        final String NO = "no\n";
        Stack<Character> braceStack = new Stack<>();
        for (int i = 0; i < line.length() - 1; i++) {
            switch(line.charAt(i)) {
                case '(':
                    braceStack.push('(');
                    break;
                case '[':
                    braceStack.push('[');
                    break;
                case ')':
                    if(braceStack.isEmpty() || !braceStack.peek().equals('(')) {
                        return NO;
                    } else {
                        braceStack.pop();
                    }
                    break;
                case ']':
                    if(braceStack.isEmpty() || !braceStack.peek().equals('[')) {
                        return NO;
                    } else {
                        braceStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }
        if(!braceStack.isEmpty()) {
            return NO;
        }
        return YES;
    }
}
