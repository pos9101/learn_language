package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 5575
 * @link https://www.acmicpc.net/problem/5575
 */
public class TimeCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            if (s2 < s) {
                --m2;
                s2 += 60;
            }
            if(m2 < m) {
                --h2;
                m2 += 60;
            }
            int answerS = s2 - s;
            int answerM = m2 - m;
            int answerH = h2 - h;
            bw.write(answerH + " " + answerM + " " + answerS + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
