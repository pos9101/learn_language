package silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * Baekjoon 15654
 * @link https://www.acmicpc.net/problem/15654
 */
public class NAndM5 {

    private static int N;
    private static int M;
    private static int[] array;
    private static boolean[] visited;
    private static BufferedWriter bw;
    private static int[] save;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        array = new int[N];
        visited = new boolean[N];
        save = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        calculateSave(0);
        bw.flush();
        br.close();
        bw.close();
    }

    private static void calculateSave(int count) throws IOException {
        if (count == M) {
            StringJoiner sj = new StringJoiner(" ");
            for (int s : save) {
                sj.add(String.valueOf(s));
            }
            bw.write(sj.toString() + "\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                save[count] = array[i];
                calculateSave(count + 1);
                visited[i] = false;
            }
        }
    }

}
