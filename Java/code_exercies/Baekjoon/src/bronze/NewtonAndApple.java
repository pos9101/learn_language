package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 13118
 * @link https://www.acmicpc.net/problem/13118
 */
public class NewtonAndApple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int p3 = Integer.parseInt(st.nextToken());
        int p4 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        if (x == p1) {
            System.out.println("1");
        } else if (x == p2) {
            System.out.println("2");
        } else if (x == p3) {
            System.out.println("3");
        } else if (x == p4) {
            System.out.println("4");
        } else {
            System.out.println("0");
        }
        br.close();
    }
}
