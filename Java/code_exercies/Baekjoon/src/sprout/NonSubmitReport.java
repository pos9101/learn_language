package sprout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Baekjoon 5597
 * @link https://www.acmicpc.net/problem/5597
 */
public class NonSubmitReport {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> submitter = new HashSet<>();
        final int NUM_OF_PEOPLE = 30;
        //Set 등록
        for(int i = 1; i <= NUM_OF_PEOPLE; i++) {
            submitter.add(i);
        }

        for (int i = 0; i < 28; i++) {
            int number = Integer.parseInt(br.readLine());
            submitter.remove(number);
        }

        for (Integer remainer : submitter) {
            System.out.println(remainer);
        }
    }
}
