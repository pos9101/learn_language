package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 11650
 * @link https://www.acmicpc.net/problem/11650
 */
public class SortCoordinates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            putInMap(treeMap, x, y);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : treeMap.entrySet()) {
            Collections.sort(entry.getValue());
            for (Integer value : entry.getValue()) {
                bw.write(entry.getKey() + " " + value + "\n");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }

    public static void putInMap(Map<Integer, ArrayList<Integer>> map, int x, int y) {
        if (!map.containsKey(x)) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(y);
            map.put(x, list);
            return;
        }
        ArrayList<Integer> list = map.get(x);
        list.add(y);
    }
}
