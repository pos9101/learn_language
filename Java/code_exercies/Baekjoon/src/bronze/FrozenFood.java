package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 14625
 * @link https://www.acmicpc.net/problem/14625
 */
public class FrozenFood {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int START_H = Integer.parseInt(st.nextToken());
        final int START_M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        final int END_H = Integer.parseInt(st.nextToken());
        final int END_M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(br.readLine());
        int result = 0;
        boolean end = false;
        for (int h = START_H; h < 24; h++) {
            for (int m = 0; m < 60; m++) {
                if(h < START_H || h == START_H && m < START_M) {
                    continue;
                } else if (h > END_H || h == END_H && m > END_M){
                    end = true;
                    break;
                }
                String now = String.format("%02d%02d", h, m);
                if (now.contains(String.valueOf(N))) {
                    result++;
                }
            }
            if(end) break;
        }
        System.out.println(result);
        br.close();
    }
}
