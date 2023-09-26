package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Baekjoon 18870
 * @link https://www.acmicpc.net/problem/18870
 */
public class CoordinateCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(" ");
        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        TreeMap<Integer, Integer> integerMap = new TreeMap<>();
        int[] originArray = new int[N];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            originArray[i] = val;
            integerMap.put(val, 0);
        }
        int sequence = 0;
        for (Integer key : integerMap.keySet()) {
            integerMap.put(key, sequence++);
        }
        for (int i = 0; i < N; i++) {
            sj.add(String.valueOf(integerMap.get(originArray[i])));
        }
        System.out.println(sj.toString());
        br.close();
    }
}
