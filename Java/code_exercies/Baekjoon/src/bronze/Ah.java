package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 4999
 * @link https://www.acmicpc.net/problem/4999
 */
public class Ah {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();
        String doctor = br.readLine();
        if (sound.length() >= doctor.length()) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
        br.close();
    }
}

