package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 25314
 * @link https://www.acmicpc.net/problem/25314
 */
public class CodingIsPhysicalEducation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i+=4) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb.toString());
        br.close();
    }
}
