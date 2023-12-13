package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 2903
 * @link https://www.acmicpc.net/problem/2903
 */
public class CentralMovementAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        //N     square      answer      answer - square
        //0     1           4           3
        //1     4           9           5
        //2     16          25          9
        //3     64          81          17
        //4     256         289         33
        //5     1024        1089        65
        //6     4096        4225        129
        //7     16384       16641       257
        //8     65536       66048       513
        //9     262144
        //10    1048576
        //11    4194304
        //12    16777216
        //13    67108864
        //14    268435456
        //15    1073741824              65537
        int answer = (int) (Math.pow(4, N) + Math.pow(2, N + 1) + 1);
        System.out.println(answer);
        br.close();
    }
}
