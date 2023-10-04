package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 6502
 * @link https://www.acmicpc.net/problem/6502
 */
public class DongHyukPizza {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            if(r == 0) break;
            ++i;
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            boolean isFit = 2 * r >= Math.sqrt(w * w + l * l);
            String message;
            if(isFit) {
                message = " fits on the table.";
            } else {
                message = " does not fit on the table.";
            }
            System.out.println("Pizza " + i + message);
        }
        br.close();
    }
}
