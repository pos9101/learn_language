package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Baekjoon 3009
 * @link https://www.acmicpc.net/problem/3009
 */
public class FourthDot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            putInMap(xMap, x);
            int y = Integer.parseInt(st.nextToken());
            putInMap(yMap, y);
        }
        StringJoiner sj = new StringJoiner(" ");
        for (Map.Entry<Integer, Integer> xEntry : xMap.entrySet()) {
            if(xEntry.getValue() == 1) sj.add(String.valueOf(xEntry.getKey()));
        }
        for (Map.Entry<Integer, Integer> yEntry : yMap.entrySet()) {
            if(yEntry.getValue() == 1) sj.add(String.valueOf(yEntry.getKey()));
        }
        System.out.println(sj.toString());
    }

    static private void putInMap(Map<Integer, Integer> map, int key) {
        if(map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }
}
