package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 10039
 * @link https://www.acmicpc.net/problem/10039
 */
public class AverageScore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = calScore(Integer.parseInt(br.readLine()));
        int b = calScore(Integer.parseInt(br.readLine()));
        int c = calScore(Integer.parseInt(br.readLine()));
        int d = calScore(Integer.parseInt(br.readLine()));
        int e = calScore(Integer.parseInt(br.readLine()));
        System.out.println((a + b + c + d + e) / 5);
        br.close();
    }

    private static int calScore(int score) {
        if(score > 40) return score;
        return 40;
    }
}
