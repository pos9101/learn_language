package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Baekjoon 1208
 * @link https://www.acmicpc.net/problem/1208
 */
public class SumOfSubset2 {
    static int N;
    static int half;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        half = N / 2;
        final int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> firstMap = takeCombinationMap(Arrays.copyOfRange(array, 0, half));
        Map<Integer, Integer> secondMap = takeCombinationMap(Arrays.copyOfRange(array, half, N));

        long answer = 0;
        for (int val : firstMap.keySet()) {
            if(secondMap.containsKey(S - val)) {
                answer += (long) firstMap.get(val) * secondMap.get(S - val);
            }
        }
        if(S == 0) --answer;
        System.out.println(answer);
        br.close();
    }

    private static Map<Integer, Integer> takeCombinationMap(int[] array) {
        Map<Integer, Integer> returnMap = new HashMap<>();
        boolean[] visited = new boolean[array.length];
        takeSubSet(returnMap, array, visited, 0);

        return returnMap;
    }

    private static void takeSubSet(Map<Integer, Integer> returnMap, int[] array, boolean[] visited, int index) {
        if(index == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                if(visited[i]) sum += array[i];
            }
            if(returnMap.containsKey(sum)) {
                returnMap.put(sum, returnMap.get(sum) + 1);
            } else {
                returnMap.put(sum, 1);
            }
            return;
        }
        visited[index] = true;
        takeSubSet(returnMap, array, visited, index + 1);
        visited[index] = false;
        takeSubSet(returnMap, array, visited, index + 1);
    }
}
