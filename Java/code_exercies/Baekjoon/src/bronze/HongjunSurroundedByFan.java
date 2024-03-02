package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 14581
 * @link https://www.acmicpc.net/problem/14581
 */
public class HongjunSurroundedByFan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String id = br.readLine();
        System.out.println(":fan::fan::fan:");
        System.out.println(":fan::" +id + "::fan:");
        System.out.println(":fan::fan::fan:");
        br.close();
    }
}
