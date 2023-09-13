package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 1436
 * @link https://www.acmicpc.net/problem/1436
 */
public class DirectorShom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int num = 666;
        int presentNum = 665;
        for (int j = 0; j < N; j++) {
            while(true) {
                ++presentNum;
                if(String.valueOf(presentNum).contains("666")) {
                    break;
                }
            }
        }
        System.out.println(presentNum);
        br.close();
    }
}
