package bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Baekjoon 5073
 * @link https://www.acmicpc.net/problem/5073
 */
public class TriangleAndThreeSides {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0) break;
            bw.write(printTriangle(a, b, c) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static String printTriangle(int... values) {
        int max = Arrays.stream(values).max().getAsInt();
        int sum = Arrays.stream(values).sum();
        int other2Values = sum - max;
        if(other2Values <= max) return "Invalid";
        if(other2Values == max * 2) return "Equilateral";
        if(Arrays.stream(values).distinct().count() == 3) return "Scalene";
        return "Isosceles";
    }
}
