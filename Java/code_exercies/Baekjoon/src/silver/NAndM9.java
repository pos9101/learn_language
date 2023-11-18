package silver;

import java.io.*;
import java.util.*;

/**
 * Baekjoon 15663
 * @link https://www.acmicpc.net/problem/15663
 */
public class NAndM9 {

    private static int N;
    private static int M;
    private static boolean[] visited;
    private static int[] array;
    private static int[] chooseM;
    private static BufferedWriter bw;
    private static Set<String> answer = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        array = new int[N];
        chooseM = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        backTracking(0);
        for (String a : answer) {
            bw.write(a + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backTracking(int count) throws IOException {
        if (count == M) {
            StringJoiner sj = new StringJoiner(" ");
            for (int i = 0; i < M; i++) {
                sj.add(String.valueOf(chooseM[i]));
            }
            answer.add(sj.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                chooseM[count] = array[i];
                backTracking(count + 1);
                visited[i] = false;
            }
        }
    }
}
