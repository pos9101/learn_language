package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Baekjoon 12015
 * @link https://www.acmicpc.net/problem/12015
 */
public class LongestIncreasingSequence2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        ArrayList<Integer> sequence = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        sequence.add(array[0]);
        for (int i = 1; i < N; i++) {
            findSequence(array, sequence, array[i]);
        }
        System.out.println(sequence.size());
        br.close();
    }

    private static void findSequence(int[] array, ArrayList<Integer> sequence, int num) {
        int s = 0;
        int e = sequence.size() - 1;
        //smaller than first
        if(num < sequence.get(s)) {
            sequence.set(s, num);
            return;
        }
        //bigger than last
        if(num > sequence.get(e)){
            sequence.add(num);
        }
        while (s + 1 < e) {
            int mid = (s + e) / 2;
            if (sequence.get(mid) < num) {
                s = mid;
            } else {
                e = mid;
            }
        }
        if (num > sequence.get(s) && num < sequence.get(e)) {
            sequence.set(e, num);
        }
    }
}
