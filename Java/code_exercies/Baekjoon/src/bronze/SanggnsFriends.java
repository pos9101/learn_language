package bronze;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 5717
 *
 * @link https://www.acmicpc.net/problem/5717
 */
public class SanggnsFriends {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());
            if(M == 0 && F == 0) break;
            bw.write((M + F) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
