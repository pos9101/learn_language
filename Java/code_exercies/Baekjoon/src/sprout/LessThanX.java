package sprout;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Baekjoon 10871
 * @link https://www.acmicpc.net/problem/10871
 */
public class LessThanX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        int i = 0;
        while(st.hasMoreTokens()){
            array[i++] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        for (int num : array) {
            if(num < x) {
                sb.append(num + " ");
            }
        }
        bw.write(sb.substring(0, sb.length() -1));
        bw.flush();

        br.close();
        bw.close();
    }
}
