package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Baekjoon 1918
 * @link https://www.acmicpc.net/problem/1918
 */
public class TheBackwardExpression {

    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < line.length(); i++) {
            actCharacter(sb, line.charAt(i));
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.toString());
        br.close();
    }

    private static void actCharacter(StringBuffer sb, char c) {
        if (c >= 'A' && c <= 'Z') {
            sb.append(c);
            return;
        }
        if (stack.isEmpty()) {
            stack.push(c);
            return;
        }
        char last;
        switch (c) {
            case '*': case '/': case '+': case '-':
                last = stack.peek();
                while (takeGrade(c) <= takeGrade(last)) {
                    sb.append(stack.pop());
                    if (stack.isEmpty()) break;
                    last = stack.peek();
                }
                stack.push(c);
                return;
            case '(':
                stack.push(c);
                return;
            case ')':
            default:
                last = stack.pop();
                while (last != '(') {
                    sb.append(last);
                    last = stack.pop();
                }
        }
    }

    private static int takeGrade(char c) {
        switch (c) {
            case '*': case '/':
                return 3;
            case '+': case '-':
                return 2;
            default:    // '(', ')'
                return 1;
        }
    }
}
