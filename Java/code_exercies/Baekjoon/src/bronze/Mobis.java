package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 28074
 * @link https://www.acmicpc.net/problem/28074
 */
public class Mobis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if(canMobis(line)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        br.close();
    }

    private static boolean canMobis(String line) {
        if (!line.contains("M")) {
            return false;
        }
        if (!line.contains("O")) {
            return false;
        }
        if (!line.contains("B")) {
            return false;
        }
        if (!line.contains("I")) {
            return false;
        }
        if (!line.contains("S")) {
            return false;
        }
        return true;
    }
}
