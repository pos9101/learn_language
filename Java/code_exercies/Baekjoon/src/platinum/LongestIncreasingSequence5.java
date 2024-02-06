package platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Baekjoon 14003
 * @link https://www.acmicpc.net/problem/14003
 */
public class LongestIncreasingSequence5 {
    static int N;
    static int[] array;
    static int[] position;
    static ArrayList<Integer> sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        array = new int[N];
        position = new int[N];
        Arrays.fill(position,  -1);
        sequence = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> array[i] = Integer.parseInt(st.nextToken()));
        calculateSequence();
        System.out.println(sequence.size());
        System.out.println(takeCalculateSequence());
        br.close();
    }

    private static String takeCalculateSequence() {
        int index = sequence.size() - 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (position[i] == index) {
                stack.push(array[i]);
                --index;
            }
            if (index < 0) break;
        }
        StringJoiner sj = new StringJoiner(" ");
        while (!stack.isEmpty()) {
            sj.add(String.valueOf(stack.pop()));
        }
        return sj.toString();
    }

    private static void calculateSequence() {
        position[0] = 0;
        sequence.add(array[0]);
        IntStream.range(1, N).forEach(i -> {
            findSequence(i, array[i]);
        });
    }

    private static void findSequence(int index, int num) {
        int s = 0;
        int e = sequence.size() - 1;
        //smaller than first
        if(num < sequence.get(s)) {
            sequence.set(0, num);
            position[index] = 0;
            return;
        }
        //bigger than last
        if (num > sequence.get(e)) {
            position[index] = sequence.size();
            sequence.add(num);
            return;
        }
        while (s + 1 < e) {
            int mid = (s + e) / 2;
            if(sequence.get(mid) < num) {
                s = mid;
            } else {
                e = mid;
            }
        }
        if(sequence.get(s) < num && num < sequence.get(e)) {
            sequence.set(e, num);
            position[index] = e;
        }
    }
}
