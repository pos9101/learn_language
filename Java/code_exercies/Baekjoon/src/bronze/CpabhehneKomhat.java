package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 27267
 * @link https://www.acmicpc.net/problem/27267
 */
public class CpabhehneKomhat {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int masha = a * b;
        int petina = c * d;
        if(masha > petina) {
            System.out.println("M");
        } else if(masha < petina) {
            System.out.println("P");
        } else {
            System.out.println("E");
        }
        br.close();
    }
}
