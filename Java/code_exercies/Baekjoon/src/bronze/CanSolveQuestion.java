package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 29716
 * @link https://www.acmicpc.net/problem/29716
 */
public class CanSolveQuestion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int J = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int sum = 0;
            for (int j = 0; j < line.length(); j++) {
                char val = line.charAt(j);
                if(val >= 'a' && val <= 'z') {
                    sum += 2;
                }else if(val >= 'A' && val <= 'Z') {
                    sum += 4;
                } else if (val >= '0' && val <= '9') {
                    sum += 2;
                } else {
                    sum += 1;
                }
            }
            if(sum <= J) {
                ++answer;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
