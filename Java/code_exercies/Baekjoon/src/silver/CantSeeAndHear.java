package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 1764
 * @link https://www.acmicpc.net/problem/1764
 */
public class CantSeeAndHear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        Set<String> nSet = new HashSet<>();
        TreeMap<String, String> resultMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            nSet.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String word = br.readLine();
            if(nSet.contains(word)) {
                resultMap.put(word, word);
            }
        }
        bw.write(resultMap.size() + "\n");
        for (String s : resultMap.keySet()) {
            bw.write(s + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
