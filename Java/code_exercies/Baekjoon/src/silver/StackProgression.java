package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Baekjoon 1874
 * @link https://www.acmicpc.net/problem/1874
 */
public class StackProgression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Stack<Integer> stackMemory = new Stack<>();
        int[] targetNum = new int[N];
        for (int i = 0; i < N; i++) {
            targetNum[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(actStack(stackMemory, targetNum, N));
        br.close();
    }

    private static String actStack(Stack<Integer> stackMemory, int[] targetNums, final int N) {
        int num = 1;
        StringBuffer sb = new StringBuffer();
        for (int target : targetNums) {
            boolean canExit = false;
            while(num <= N + 1) {
                String ret = findTarget(stackMemory, target, num);
                switch (ret) {
                    case "NO":
                        return "NO\n";
                    case "-":
                        sb.append("-\n");
                        canExit = true;
                        break;
                    case "+":
                        sb.append("+\n");
                        num++;
                        break;
                }
                if(canExit) break;
            }
        }
        return sb.toString();
    }

    private static String findTarget(Stack<Integer> stack, final int target, final int num) {
        if(target >= num) {
            stack.push(num);
            return "+";
        }
        if(stack.isEmpty()) {
            return "NO";
        }
        if (stack.peek() != target) {
            return "NO";
        }
        stack.pop();
        return "-";
    }


}
