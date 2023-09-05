package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


/**
 * Baekjoon 2798
 * @link https://www.acmicpc.net/problem/2798
 */
public class BlackJack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] valueArray = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            valueArray[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findAnswer(n, m, valueArray));

        br.close();
    }

    private static int findAnswer(int n, int m, int[] valueArray) {
        int answer = 0;

        TreeSet<Integer> threeSumSets = new TreeSet<>();
        for (int i = 0; i < n -2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    threeSumSets.add(valueArray[i] + valueArray[j] + valueArray[k]);
                }
            }
        }

        return threeSumSets.stream().filter(x -> x <= m).mapToInt(x -> x)
                .max().getAsInt();
    }
}
