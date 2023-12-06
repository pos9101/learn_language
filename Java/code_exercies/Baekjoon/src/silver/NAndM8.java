package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 15657
 * @link https://www.acmicpc.net/problem/15657
 */
public class NAndM8 {
    static int N;
    static int M;
    static Set<String> answer;
    static int[] array;
    static int[] pickedArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        pickedArray = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        answer = new LinkedHashSet<>();
        pickNum(0, 0);
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void pickNum(int start, int index) {
        if(index == M) {
            StringJoiner sj = new StringJoiner(" ");
            for (int value : pickedArray) {
                sj.add(String.valueOf(value));
            }
            answer.add(sj.toString());
            return;
        }
        for (int i = start; i < N; i++) {
            pickedArray[index] = array[i];
            pickNum(i, index + 1);
        }
    }
}
