package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Baekjoon 10101
 * @link https://www.acmicpc.net/problem/10101
 */
public class MemorizingTriangles {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        System.out.println(calculateTriangle(a, b, c));
        br.close();
    }

    private static String calculateTriangle(int a, int b, int c) {
        if(a + b + c != 180) return "Error";
        int sameAngle = 0;
        if(a == b) ++sameAngle;
        if(b == c) ++sameAngle;
        if(a == c) ++sameAngle;
        if (sameAngle == 0) return "Scalene";
        if (sameAngle == 1) return "Isosceles";
        return "Equilateral";
    }
}
