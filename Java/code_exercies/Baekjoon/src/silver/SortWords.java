package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 1181
 * @link https://www.acmicpc.net/problem/1181
 */
public class SortWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        //key : word Length
        //value : word List
        Map<Short, TreeSet<String>> lengthIndexMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            putInIndexMap(lengthIndexMap, word);
        }

        lengthIndexMap.values().forEach(x -> {
            x.stream().forEach(y -> sb.append(y + "\n"));
        });

        System.out.println(sb.toString());
        br.close();
    }

    private static void putInIndexMap(Map<Short, TreeSet<String>> lengthIndexMap, String word) {
        if(lengthIndexMap.containsKey((short)word.length())) {
            lengthIndexMap.get((short)word.length()).add(word);
        } else {
            TreeSet<String> stringTreeSet = new TreeSet<>();
            stringTreeSet.add(word);
            lengthIndexMap.put((short) word.length(), stringTreeSet);
        }
    }
}
