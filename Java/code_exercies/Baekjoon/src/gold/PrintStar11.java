package gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Baekjoon 2448
 * @link https://www.acmicpc.net/problem/2448
 */
public class PrintStar11 {
    static BufferedWriter bw;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        List<String> answer = drawStar(N);
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static List<String> drawStar(int num) throws IOException {
        if (num == 3) {
            ArrayList<String> val = new ArrayList<>();
            val.add("  *   ");
            val.add(" * *  ");
            val.add("***** ");
            return val;
        }
        List<String> returnValue = new ArrayList<>();
        List<String> miniStar = drawStar(num / 2);
        for (int i = 0; i < miniStar.size(); i++) {
            String s = miniStar.get(i);
            returnValue.add(" ".repeat(num / 2) + s + " ".repeat(num / 2));
        }
        for (int i = 0; i < miniStar.size(); i++) {
            String s = miniStar.get(i);
            returnValue.add(s + s);
        }
        return returnValue;
    }
}
