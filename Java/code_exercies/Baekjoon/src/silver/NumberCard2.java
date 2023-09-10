package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.IntPredicate;

/**
 * Baekjoon 10816
 * @link https://www.acmicpc.net/problem/10816
 */
public class NumberCard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        //key : num, value : count
        Map<Integer, Integer> nCountMap = fillMap(N, br);
        final int M = Integer.parseInt(br.readLine());
        int[] mArray = fillMArray(br, M);

        StringJoiner sj = new StringJoiner(" ");
        Arrays.stream(mArray).forEach(x -> sj.add(String.valueOf(nCountMap.getOrDefault(x, 0))));
        System.out.println(sj.toString());
        br.close();
    }

    private static Map<Integer, Integer> fillMap(int N, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> nCountMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(nCountMap.containsKey(num)) {
                nCountMap.put(num, nCountMap.get(num) + 1);
            } else {
                nCountMap.put(num, 1);
            }
        }
        return nCountMap;
    }

    private static int[] fillMArray(BufferedReader br, int M) throws IOException {
        int[] mArray = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
        }
        return mArray;
    }
}
