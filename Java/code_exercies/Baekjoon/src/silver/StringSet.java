package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Baekjoon 14425
 * @link https://www.acmicpc.net/problem/14425
 */
public class StringSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        Map<String, Boolean> stringMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            stringMap.put(br.readLine(), true);
        }
        for (int i = 0; i < M; i++) {
            if(stringMap.containsKey(br.readLine())) ++answer;
        }
        System.out.println(answer);
        br.close();
    }
}
