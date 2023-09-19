package silver;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Baekjoon 17219
 * @link https://www.acmicpc.net/problem/17219
 *
 */
public class FindPassword {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> sitePasswordMap = new HashMap<>();
        //Mapping
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            sitePasswordMap.put(st.nextToken(), st.nextToken());
        }
        //Get
        for (int i = 0; i < M; i++) {
            bw.write(sitePasswordMap.get(br.readLine()) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
