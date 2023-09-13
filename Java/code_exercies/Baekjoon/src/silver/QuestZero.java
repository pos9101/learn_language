package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Baekjoon 10773
 * @link https://www.acmicpc.net/problem/10773
 */
public class QuestZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            actStack(stack, num);
        }
        System.out.println(stack.stream().reduce(0, (total, value) -> total + value).longValue());


        br.close();
    }

    private static void actStack(LinkedList<Integer> stack, int num) {
        if( num != 0 ) {
            stack.push(num);
        } else {
            stack.pop();
        }
    }
}
