package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 5525
 * @link https://www.acmicpc.net/problem/5525
 */
public class Ioioi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        String s = "IOI";
        int pnLength = 2 * N;
        char[] lineArray = br.readLine().toCharArray();

        int answer = 0;
        int i = 0;
        int startIdx = 0;
        int endIdx = 0;
        while(i + 2 < M) {
            String compareString = new String(lineArray, i, 3);
            if(s.equals(compareString)) {
                i += 2;
                endIdx = i;
            } else {
                ++i;
                startIdx = i;
                endIdx = i;
            }
            if(endIdx - startIdx >= pnLength) {
                ++answer;
            }

        }
        System.out.println(answer);
        br.close();
    }
}
