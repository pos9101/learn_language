package gold;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 10942
 * @link https://www.acmicpc.net/problem/10942
 */
public class IsPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];
        boolean[][] isPalindrome = new boolean[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        final int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            bw.write(findPalindrome(array, isPalindrome, s, e) ? "1\n" : "0\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }

    private static boolean findPalindrome(int[] array, boolean[][] isPalindrome, int s, int e) {
        if(isPalindrome[s][e]) return true;
        if(s == e) {
            isPalindrome[s][e] = true;
            return true;
        }
        for (int i = 0; i < (e - s) / 2 + 1; i++) {
            if(array[s + i] != array[e - i]) return false;
        }
        for (int i = 0; i < (e - s) / 2 + 1; i++) {
            isPalindrome[s + i][e - i] = true;
        }
        return true;
    }
}
