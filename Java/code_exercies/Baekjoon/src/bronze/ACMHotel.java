package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 10250
 * @link https://www.acmicpc.net/problem/10250
 */
public class ACMHotel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int countN = n - 1; // There are 0 ~ 4 not 1 ~ 5, if you want to count 5th

            int roomNum = countN / h + 1;
            int floor = countN % h + 1;

            bw.write(floor + String.format("%02d", roomNum) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
