package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 2108
 * @link https://www.acmicpc.net/problem/2108
 */
public class Statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        int[] values = new int[N];
        //key : num, value : times
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(br.readLine());
            fillTimesMap(timesMap, values[i]);
        }

        values = Arrays.stream(values).sorted().toArray();
        if(N != 1) {
            //Arithmetic mean
            bw.write(Math.round(Arrays.stream(values).average().getAsDouble()) + "\n");
            //median value
            bw.write(values[N/2] + "\n");
            //mode
            bw.write(calculateMode(timesMap) + "\n");
            //range
            bw.write(values[N - 1] - values[0] + "\n");
        } else {
            bw.write(values[0] + "\n");
            bw.write(values[0] + "\n");
            bw.write(values[0] + "\n");
            bw.write("0\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void fillTimesMap(Map<Integer, Integer> timesMap, int indexValue) {
        if(timesMap.containsKey(indexValue)) {
            timesMap.put(indexValue, timesMap.get(indexValue) + 1);
        } else {
            timesMap.put(indexValue, 1);
        }
    }

    private static int calculateMode(Map<Integer, Integer> timesMap) {
        int max = timesMap.values().stream().max(Integer::compareTo).get();
        Object[] array = timesMap.keySet().stream().filter(x -> timesMap.get(x) == max).sorted(Integer::compareTo).toArray();
        if(array.length == 1) {
            return (int) array[0];
        } else {
            return (int) array[1];
        }
    }
}
