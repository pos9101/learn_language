package silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Baekjoon 10814
 * @link https://www.acmicpc.net/problem/10814
 */
public class SortOlder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int N = Integer.parseInt(br.readLine());
        TreeMap<Short, LinkedList<String>> ascendingAgeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            short age = Short.parseShort(st.nextToken());
            String name = st.nextToken();
            if (ascendingAgeMap.containsKey(age)) {
                ascendingAgeMap.get(age).add(name);
            } else {
                LinkedList<String> names = new LinkedList<>();
                names.add(name);
                ascendingAgeMap.put(age, names);
            }
        }

        for (Map.Entry<Short, LinkedList<String>> entry : ascendingAgeMap.entrySet()) {
            LinkedList<String> names = entry.getValue();
            for (String name : names) {
                bw.write(entry.getKey() + " " + name + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    

}
