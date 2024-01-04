package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 2083
 * @link https://www.acmicpc.net/problem/2083
 */
public class RugbyClub {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            String line = br.readLine();
            if(line.equals("# 0 0")) break;
            StringTokenizer st = new StringTokenizer(line, " ");
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            String clubName = (age > 17 || weight >= 80) ? "Senior" : "Junior";
            bw.write(name + " " + clubName + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
