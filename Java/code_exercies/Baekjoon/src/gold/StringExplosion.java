package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Baekjoon 9935
 * @link https://www.acmicpc.net/problem/9935
 */
public class StringExplosion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String explosionWord = br.readLine();
        char lastExplosionWord = explosionWord.charAt(explosionWord.length() - 1);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            stack.push(line.charAt(i));
            Character last = stack.peek();
            if (last == lastExplosionWord && stack.size() >= explosionWord.length()) {
                //pop
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < explosionWord.length(); j++) {
                    sb.append(stack.pop());
                }
                //compareString
                if (!sb.reverse().toString().equals(explosionWord)) {
                    String string = sb.toString();
                    for (int j = 0; j < string.length(); j++) {
                        stack.push(string.charAt(j));
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.length() == 0 ? "FRULA" : sb.reverse().toString());
        br.close();
    }
}
