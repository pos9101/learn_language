package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * Baekjoon 2750
 * @link https://www.acmicpc.net/problem/2750
 */
public class ArrangeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
