package bronze;

import java.io.*;

/**
 * Baekjoon 10989
 * @link https://www.acmicpc.net/problem/10989
 */
public class ArrangeNums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestcase = Integer.parseInt(br.readLine());

        int[] timesArray = new int[10001];

        for (int i = 0; i < numOfTestcase; i++) {
            short num = Short.parseShort(br.readLine());
            timesArray[num]++;
        }

        for (int i = 1; i <= 10000; i++) {
            int times = timesArray[i];
            for (int j = 0; j < times; j++) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
