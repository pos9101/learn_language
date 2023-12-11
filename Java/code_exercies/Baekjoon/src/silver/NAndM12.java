package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 15666
 * @link https://www.acmicpc.net/problem/15666
 */
public class NAndM12 {
    static int N;
    static int M;
    static BufferedWriter bw;
    static Set<String> answer = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        int[] choose = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        chooseNums(array, choose, 0, 0);
        for (String s : answer) {
            bw.write(s);
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void chooseNums(int[] array, int[] choose, int start, int count) throws IOException {
        if (count == M) {
            StringJoiner sj = new StringJoiner(" ");
            for (int i : choose) {
                sj.add(String.valueOf(i));
            }
            answer.add(sj.toString() + "\n");
            return;
        }
        for (int i = start; i < N; i++) {
            choose[count] = array[i];
            chooseNums(array, choose, i, count + 1);
        }
    }
}
