package bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 4153
 * @link https://www.acmicpc.net/problem/4153
 */
public class RightTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] sides = new int[3];
            for (int i = 0; i < 3; i++) {
                sides[i] = Integer.parseInt(st.nextToken());
            }
            if(Arrays.stream(sides).sum() <= 0) {
                break;
            }
            //Pythagorean theorem if(a^2 + b^2 == c^2)  right triangle true
            bw.write(isRightTriangle(sides) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static String isRightTriangle(int[] sides) {
        int c = Arrays.stream(sides).max().getAsInt();
        int[] aAndB = Arrays.stream(sides).filter(x -> x != c).toArray();
        return Math.pow(c, 2) == Math.pow(aAndB[0], 2) + Math.pow(aAndB[1], 2) ? "right" : "wrong";
    }
}
