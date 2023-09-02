package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 2675
 * @link https://www.acmicpc.net/problem/2675
 */
public class RepeatStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfTestcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int repeatNum = Integer.parseInt(st.nextToken());
            String word = st.nextToken();

            for (int j = 0; j < word.length(); j++) {
                for(int k = 0; k < repeatNum; k++) {
                    bw.write(word.charAt(j));
                }
            }
            bw.write("\n");
        }

        bw.flush();

        br.close();
        bw.close();

    }
}
