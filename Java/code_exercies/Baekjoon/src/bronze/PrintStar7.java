package bronze;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Baekjoon 2444
 * @link https://www.acmicpc.net/problem/2444
 */
public class PrintStar7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine());
        StringBuilder maxLineStar = new StringBuilder();
        maxLineStar.append("*".repeat(N * 2 - 1));
        Deque<String> stars = new LinkedList<>();
        stars.add(maxLineStar.toString());
        for (int i = 0; i < N - 1; i++) {
            maxLineStar.setCharAt(i, ' ');
            maxLineStar.deleteCharAt(N * 2 - 2 - i);
            stars.addFirst(maxLineStar.toString());
            stars.addLast(maxLineStar.toString());
        }
        for (String star : stars) {
            bw.write(star + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
