package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 24883
 * @link https://www.acmicpc.net/problem/24883
 */
public class AutoComplete {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        switch (line) {
            case "N":
            case "n":
                System.out.println("Naver D2");
                break;
            default:
                System.out.println("Naver Whale");
                break;
        }
        br.close();
    }
}
