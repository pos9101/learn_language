package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 10797
 * @link https://www.acmicpc.net/problem/10797
 */
public class TenPartSystem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int day = Integer.parseInt(br.readLine());
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 5; i++) {
            int carNum = Integer.parseInt(st.nextToken());
            if(carNum == day) ++answer;
        }
        System.out.println(answer);
        br.close();
    }
}
